package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.Product;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    private Map<String,Object> configs = null;
    private int outputPage = 1;

    public ApiResponse() throws IOException {}

    public String getProductNumberFromKeyword(String searchKeyword,Map<String,Object> outputDataCriteria){
        String productNumber = null;
        boolean flag = true;
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 3 && data.getSizes().size() >= 3) {
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
                productNumber = getProductForInputParams(product,outputDataCriteria);
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

    private Product getProductDetailsForKeyword(String searchKeyword,boolean firstTimeFunctionCall){
        Response response = null;
        Product product = null;
        boolean flag = true;
        //Clearing config data before start of function is it is saved as previous call
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
                product = getResponseObject(response.asString(), new TypeReference<Product>() {
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

    private Response getApiCallResponse(Map<String,Object> config,String apiEndPoint){
        return RestAssured.given().
                when().params(config).header("Content-Type","application/json").log().all().
                get(apiEndPoint);
    }

    private String getDimensionNumberFromURL(String url){
        return url.split(":")[1];
    }

    private <T> T getResponse(String response, Class<T> returnClassType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response,returnClassType);
    }

    private <T> T getResponseObject(String response, TypeReference<T> typeReference){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response,typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getProductForInputParams(Product product,Map<String,Object> configs){
        for(Product.Products data:product.getProducts()) {
            int videoCount=0,styleCount=0,sizeCount=0;
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
            if(data.getVideosCount()>=videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount){
                return data.getItemNo();
            }
        }
        return "No Item Found";
    }
}
