package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.Product.edps;
import com.tsc.api.pojo.SelectedProduct;
import com.tsc.api.util.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    private Map<String,Object> configs = null;
    private int outputPage = 1;
    private int totalPage;
    private String dimensionNumber;

    public ApiResponse() throws IOException {}

    /**
     * This method finds product number on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
     * @return - SelectedProduct - product for search keyword
     */
    public SelectedProduct getProductNumberFromKeyword(String searchKeyword,Map<String,Object> outputDataCriteria){
        boolean flag = true;
        String lsNowPrice,lsWasPrice;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }
        SelectedProduct selectedProduct= new SelectedProduct();
        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                	selectedProduct.productNumber="";
            		selectedProduct.productName="";
            		selectedProduct.productBrand="";
            		selectedProduct.productNowPrice="";
            		selectedProduct.productWasPrice="";
            		selectedProduct.pdpNavigationUrl="";
            		
                	lsNowPrice=data.getIsPriceRange();
                	lsWasPrice=data.getWasPriceRange();
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 3 && data.getSizes().size() >= 3&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
                    	if(data.getBrand()!=null) {
                    		if(data.getBrand().isEmpty()) {
                    			continue;
                    		}                    		
                    	}
                    	else {
                    		continue;
                    	}
                    	
                        flag = false;
                        selectedProduct.productNumber=data.getItemNo();
                		selectedProduct.productName=data.getName();
                		selectedProduct.productBrand=data.getBrand();
                		selectedProduct.productNowPrice=data.getIsPriceRange();
                		selectedProduct.productWasPrice=data.getWasPriceRange();
                		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+"/pages/productdetails?nav=R:"+data.getItemNo();            	
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,false);
                }
            }else{
            	selectedProduct = getProductNumberForInputParams(product,outputDataCriteria);
                if(selectedProduct==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }                    
                    product = getProductDetailsForKeyword(searchKeyword,false);
                 }else{
                    flag = false;
                }
            }
            
        }while(flag);

        return selectedProduct;
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
        Map<String, Object> initialConfig=new HashMap<>();
        int repeatNumber=0;
        
        //Clearing config data before start of function if this function call was made previously in test
        if(configs!=null)
            configs.clear();
        if(firstTimeFunctionCall) {
        	outputPage = 1;
        }
    
        if(firstTimeFunctionCall) {
        	initialConfig.put("searchTerm", searchKeyword);        	
        	
            do {
    	        try{
    	            response = getApiCallResponse(initialConfig,"/products");    	            
    	        }catch (Exception exception){
    	            exception.printStackTrace();
    	        }
    	        product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {});	       
    	        if(product.getRedirectUrl()!=null) {
    	        	 dimensionNumber = getDimensionNumberFromURL(product.getRedirectUrl());
     	             break;
    	        }
    	        repeatNumber++;
    	        if(repeatNumber==5) {
    	        	return null;
    	        }
            }while(true);
        }

        configs = super.getProductSearchByKeywordInputConfig(searchKeyword, dimensionNumber, outputPage, super.getApiPropertyData().get("test_apiVersion"));
        
        repeatNumber=0;
        do{
        	response = getApiCallResponse(configs, "/products");
            if(response!=null && response.statusCode()==200) {
            	product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {
                });

                if (product.getProducts().size() >= 1) {
                	totalPage=product.getPaging().getTotalPages();
                    flag = false;
                } 

                repeatNumber++;
                if(repeatNumber==5) {
                	return null;
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
    	String lsDimension;
    	String lsVersion= super.getApiPropertyData().get("test_apiVersion");

    	if(lsVersion.equalsIgnoreCase("v2")) {
    		lsDimension=url.split(":")[1];    		
    	}
    	else {
    		lsDimension=url.split("=")[1];
    		if(lsDimension.contains(":")) {
    			lsDimension=url.split(":")[1];
    		}
    	}
        return lsDimension;
    }

    /**
     * This method finds product number on the basis of input conditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice)
     * @param - Product - product : Product class object
     * @param - Map<String,Object> - configs : configs on basis of which product number will be fetched
     * @return - SelectedProduct - product for search keyword
     */
    private SelectedProduct getProductNumberForInputParams(Product product,Map<String,Object> configs){
    	if(product==null) {
        	return null;
        }
    	
        int videoCount=1,styleCount=3,sizeCount=3;
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
        
        SelectedProduct selectedProduct= new SelectedProduct(); 
        for(Product.Products data:product.getProducts()) {
        	lsNowPrice=data.getIsPriceRange();
        	lsWasPrice=data.getWasPriceRange();
            if(data.getVideosCount()>=videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount &&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
            	if(data.getBrand()!=null) {
            		if(data.getBrand().isEmpty()) {
            			continue;
            		}            		
            	}
            	else {
            		continue;
            	}
            	selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+"/pages/productdetails?nav=R:"+data.getItemNo();            	
                return selectedProduct;
            }
        }
        return null;
    }
    
    /**
     * This method finds PDP url for Add To Bag enabled product
     * @param - Product - product : Product class object
     * @return - SelectedProduct - product for search keyword
     */
    private SelectedProduct getProductOfPDPForAddToBag(Product product){
    	if(product==null) {
        	return null;
        }
        SelectedProduct selectedProduct= new SelectedProduct();        
        for(Product.Products data:product.getProducts()) {
        	if(data.isEnabledAddToCart()) {
        		selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+"/pages/productdetails?nav=R:"+data.getItemNo();
        		return selectedProduct;
        	}
        }
        return null;
    }
    
    /**
     * This method finds PDP url for Add To Bag enabled product on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product
      * @return - SelectedProduct - product for search keyword
     */
    public SelectedProduct getProductOfPDPForAddToBagFromKeyword(String searchKeyword){
        boolean flag = true;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }
        
        SelectedProduct selectedProduct= new SelectedProduct();
        do{
        	selectedProduct.productNumber="";
    		selectedProduct.productName="";
    		selectedProduct.productBrand="";
    		selectedProduct.productNowPrice="";
    		selectedProduct.productWasPrice="";
    		selectedProduct.pdpNavigationUrl="";
    				
    		selectedProduct = getProductOfPDPForAddToBag(product);
            if(selectedProduct==null){
                outputPage++;
                if(outputPage>totalPage||outputPage>=10) {
                	flag = false;
                }                    
                product = getProductDetailsForKeyword(searchKeyword,false);
             }else{
                flag = false;
            }
            
        }while(flag);

        return selectedProduct;
    }
    
    /**
     * This method finds product number on the basis of input conditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice, and soldout)
     * @param - Product - product : Product class object
     * @param - Map<String,Object> - configs : configs on basis of which product number will be fetched
     * @return - SelectedProduct - product for search keyword
     */
    private SelectedProduct getProductNumberForInputParamsWithSoldOutInfo(Product product,Map<String,Object> configs){
    	if(product==null) {
        	return null;
        }
    	
        int videoCount=1,styleCount=3,sizeCount=3;
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
        
        SelectedProduct selectedProduct= new SelectedProduct(); 
        for(Product.Products data:product.getProducts()) {
        	lsNowPrice=data.getIsPriceRange();
        	lsWasPrice=data.getWasPriceRange();
            if(data.getVideosCount()>=videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount &&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
            	if(data.getBrand()!=null) {
            		if(data.getBrand().isEmpty()) {
            			continue;
            		}            		
            	}
            	else {
            		continue;
            	}
            	
            	List<edps> edpsList=data.getEdps();            	
            	for(edps Edps:edpsList) {
            		if(Edps.Inventory==0) {
            			selectedProduct.productSelectedColor=Edps.getStyle();
            			selectedProduct.productSelectedSize=Edps.getSize();
            		}
            	}
             	
            	selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+"/pages/productdetails?nav=R:"+data.getItemNo();            	
                return selectedProduct;
            }
        }
        return null;
    }
    
    /**
     * This method finds product number on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
     * @return - SelectedProduct - product for search keyword
     */
    public SelectedProduct getProductNumberFromKeywordWithSoldOutInfo(String searchKeyword,Map<String,Object> outputDataCriteria){
        boolean flag = true;
        String lsNowPrice,lsWasPrice;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }
        SelectedProduct selectedProduct= new SelectedProduct();
        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                	selectedProduct.productNumber="";
            		selectedProduct.productName="";
            		selectedProduct.productBrand="";
            		selectedProduct.productNowPrice="";
            		selectedProduct.productWasPrice="";
            		selectedProduct.pdpNavigationUrl="";
            		
                	lsNowPrice=data.getIsPriceRange();
                	lsWasPrice=data.getWasPriceRange();
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 3 && data.getSizes().size() >= 3&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
                    	if(data.getBrand()!=null) {
                    		if(data.getBrand().isEmpty()) {
                    			continue;
                    		}                    		
                    	}
                    	else {
                    		continue;
                    	}
                    	
                    	List<edps> edpsList=data.getEdps();            	
                    	for(edps Edps:edpsList) {
                    		if(Edps.Inventory==0) {
                    			selectedProduct.productSelectedColor=Edps.getStyle();
                    			selectedProduct.productSelectedSize=Edps.getSize();
                    		}
                    	}
                    	
                        flag = false;
                        selectedProduct.productNumber=data.getItemNo();
                		selectedProduct.productName=data.getName();
                		selectedProduct.productBrand=data.getBrand();
                		selectedProduct.productNowPrice=data.getIsPriceRange();
                		selectedProduct.productWasPrice=data.getWasPriceRange();
                		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+"/pages/productdetails?nav=R:"+data.getItemNo();            	
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,false);
                }
            }else{
            	selectedProduct = getProductNumberForInputParamsWithSoldOutInfo(product,outputDataCriteria);
                if(selectedProduct==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }                    
                    product = getProductDetailsForKeyword(searchKeyword,false);
                 }else{
                    flag = false;
                }
            }
            
        }while(flag);

        return selectedProduct;
    }
}
