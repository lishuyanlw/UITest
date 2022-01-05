package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Product;
import com.tsc.api.util.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    private Map<String,Object> configs = null;
    private int outputPage = 1;

    public ApiResponse() throws IOException {}

    /**
     * This method finds product number on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
     * @return - String - product no for search keyword
     */
    public String getProductNumberFromKeyword(String searchKeyword,Map<String,Object> outputDataCriteria){
        String productNumber = null;
        boolean flag = true;
        String lsNowPrice,lsWasPrice;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                	lsNowPrice=data.getIsPriceRange();
                	lsWasPrice=data.getWasPriceRange();
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 4 && data.getSizes().size() >= 3&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
                        flag = false;
                        productNumber = data.getItemNo();
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    product = getProductDetailsForKeyword(searchKeyword,false);
                }
            }else{
                productNumber = getProductNumberForInputParams(product,outputDataCriteria);
                if(productNumber.equalsIgnoreCase("No Item Found")){
                    outputPage++;
                    product = getProductDetailsForKeyword(searchKeyword,false);
                 }else{
                    flag = false;
                }
            }
        }while(flag);

        return productNumber;
    }

    /**
     * This method find Product Details for search Keyword as api call
     * @param - String - searchKeyword : search keyword for Product
     * @param - boolean - firstTimeFunctionCall : since this method is call multiple times, this parameter
     * determines as if the call is made first time or not
     * @return - Product - Product Object from api Response
     */
    private Product getProductDetailsForKeyword(String searchKeyword,boolean firstTimeFunctionCall){
        Response response = null;
        Product product = null;
        boolean flag = true;
        //Clearing config data before start of function if this function call was made previously in test
        if(configs!=null)
            configs.clear();
        if(firstTimeFunctionCall)
            outputPage = 1;
        configs = super.getProductSearchByKeywordInputConfig(searchKeyword,null,outputPage,super.getApiPropertyData().get("test_apiVersion"));
        try{
            response = getApiCallResponse(configs,"/products");
        }catch (Exception exception){
            exception.printStackTrace();
        }
        do{
            if(response!=null && response.statusCode()==200) {
                product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {
                });
                if (product.getProducts().size() >= 1 && product.getRedirectUrl() == null) {
                    flag = false;
                } else if (product.getRedirectUrl() != null) {
                    if(configs!=null)
                        configs.clear();
                    String dimension = getDimensionNumberFromURL(product.getRedirectUrl());
                    configs = super.getProductSearchByKeywordInputConfig(searchKeyword, dimension, outputPage, super.getApiPropertyData().get("test_apiVersion"));
                    response = getApiCallResponse(configs, "/products");
                }
            }
        }while(flag);
        return product;
    }

    /**
     * This method makes GET call to api
     * @param - Map<String,Object> - config : input params that are needed for GET call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    private Response getApiCallResponse(Map<String,Object> config,String apiEndPoint){
        return RestAssured.given().
                when().params(config).header("Content-Type","application/json").log().all().
                get(apiEndPoint);
    }

    /**
     * This method fetches Dimension Number from returned url
     * @param - String - url : url that contains dimension number
     * @return - String - Dimension Number
     */
    private String getDimensionNumberFromURL(String url){
        return url.split(":")[1];
    }

    /**
     * This method finds product number on the basis of input conditions(video,style,size)
     * @param - Product - product : Product class object
     * @param - Map<String,Object> - configs : configs on basis of which product number will be fetched
     * @return - String - Product Number of product
     */
    private String getProductNumberForInputParams(Product product,Map<String,Object> configs){
        int videoCount=1,styleCount=4,sizeCount=3;
        String lsNowPrice,lsWasPrice;
        
        if(configs!=null) {
        	for(Map.Entry<String,Object> entry:configs.entrySet()){
                if(entry.getKey().toLowerCase().contains("video"))
                    videoCount = Integer.valueOf(entry.getValue().toString());
                if(entry.getKey().toLowerCase().contains("style")){
                    styleCount = Integer.valueOf(entry.getValue().toString());
                }
                if(entry.getKey().toLowerCase().contains("size")){
                    sizeCount = Integer.valueOf(entry.getValue().toString());
                }                       
            }
        }
        
        for(Product.Products data:product.getProducts()) {
        	lsNowPrice=data.getIsPriceRange();
        	lsWasPrice=data.getWasPriceRange();
            if(data.getVideosCount()>=videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
//            	if(data.getBrand()!=null) {
//            		if(data.getBrand().isEmpty()) {
//            			continue;
//            		}
//            		else {
//            			System.out.println("data.getBrand(): "+data.getBrand());
//            		}
//            	}
//            	else {
//            		continue;
//            	}
            	            	
                return data.getItemNo();
            }
        }
        return "No Item Found";
    }
}
