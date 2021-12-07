package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONPointerException;

import java.io.IOException;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    public ApiResponse() throws IOException {
    }

    public Response getProductsByKeywordResponse(String searchKeyword) throws IOException {
        Response response = null;
        Map<String,Object> configs = super.getProductSearchByKeywordInputConfig(searchKeyword,null,null,super.getApiInfo().get("test_apiVersion"));
        super.setApiClient(null);
        try{
            response = RestAssured.given().
                    when().params(configs).header("Content Type","application/json").
                    get();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return response;
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
