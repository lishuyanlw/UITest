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

    public ApiResponse() throws IOException {
    }

    public Product getProductsByKeywordResponse(String searchKeyword) throws IOException {
        Response response = null;
        Map<String,Object> configs = super.getProductSearchByKeywordInputConfig(searchKeyword,null,null,super.getApiPropertyData().get("test_apiVersion"));
        try{
            response = RestAssured.given().
                    when().params(configs).header("Content-Type","application/json").log().all().
                    get("/products");
        }catch (Exception exception){
            exception.printStackTrace();
        }

        if(response.statusCode()==200) {
            return getResponseObject(response.asString(), new TypeReference<Product>() {});
        }else
            return null;
    }

    public <T> T getResponse(String response, Class<T> returnClassType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectModel = objectMapper.readValue(response,returnClassType);
        return objectModel;
    }

    public <T> T getResponseObject(String response, TypeReference<T> typeReference){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T objectModel = objectMapper.readValue(response,typeReference);
            return objectModel;
        } catch (JSONPointerException e) {
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
