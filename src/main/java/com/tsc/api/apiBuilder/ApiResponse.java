package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.Product;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONPointerException;

import java.io.IOException;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    public Map<String,Object> configs = null;
    public ApiResponse() throws IOException {}

    public Product getProductsByKeywordResponse(String searchKeyword) {
        return getProductDetailsForKeyword(searchKeyword);
    }

    public Product getProductDetailsForKeyword(String searchKeyword){
        Response response = null;
        Product product = null;
        boolean flag = true;
        //Clearing config data before start of function is it is saved as previous call
        if(configs!=null)
            configs.clear();
        int outputPage = 1;
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

    public Response getApiCallResponse(Map<String,Object> config,String apiEndPoint){
        return RestAssured.given().
                when().params(config).header("Content-Type","application/json").log().all().
                get(apiEndPoint);
    }

    public String getDimensionNumberFromURL(String url){
        return url.split(":")[1];
    }

    public <T> T getResponse(String response, Class<T> returnClassType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response,returnClassType);
    }

    public <T> T getResponseObject(String response, TypeReference<T> typeReference){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response,typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
