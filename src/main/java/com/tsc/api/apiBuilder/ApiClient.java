package com.tsc.api.apiBuilder;

import com.tsc.api.util.PropertyReader;
import io.restassured.RestAssured;

import java.io.IOException;
import java.util.Map;

public class ApiClient {
    public ApiClient() throws IOException {
    }

    public Map<String,String> getApiInfo() throws IOException {
        return PropertyReader.getPropertyDataMap();
    }

    public void setApiClient(String baseURI) throws IOException {
        if(baseURI!=null)
            RestAssured.baseURI = baseURI+"/"+getApiInfo().get("test_apiVersion")+"/"+getApiInfo().get("test_language");
        else
            RestAssured.baseURI = getApiInfo().get("test_qaURL")+"/"+getApiInfo().get("test_apiVersion")+"/"+getApiInfo().get("test_language");
    }

}
