package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Configuration;
import com.tsc.api.util.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public class ConfigurationAPI extends ApiClient{
    public ConfigurationAPI() throws IOException {super();}

    public List<Configuration> getContentFulConfigurationForFreeItem(){
        String test_URL = System.getProperty("QaUrl");

        String apiEndPoint = "https://qa-api.tsc.ca/configuration/v1/Web/";
        if(test_URL.contains("qa"))
            apiEndPoint = apiEndPoint+"QA";
        else if(test_URL.contains("st"))
            apiEndPoint = apiEndPoint+"ST";

        Response response = RestAssured.
                given().
                when().
                    header("Authorization","Basic 1321A95C-4BD0-4D29-AA55-B040D48C6992:5346C7F8").
                    get(apiEndPoint).
                then().
                    extract().response();

        if(response.getStatusCode()==200)
            return JsonParser.getResponseObject(response.asString(), new TypeReference<List<Configuration>>(){});

        return null;
    }
}
