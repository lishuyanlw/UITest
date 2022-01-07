package com.tsc.api.apiBuilder;

import com.tsc.api.util.PropertyReader;
import io.restassured.RestAssured;

import java.io.IOException;
import java.util.Map;

public class ApiClient {
    Map<String,String> propertyData;
    public ApiClient() throws IOException {
        propertyData = getApiInfo();
    }

    protected Map<String,String> getApiInfo() throws IOException {
        return PropertyReader.getPropertyDataMap();
    }

    public Map<String,String> getApiPropertyData(){
        return propertyData;
    }

    /**
     * This method sets base URI for api
     * @param - String - baseURI - baseURI for the api
     * @return - void
     */
    public void setApiClient(String baseURI) throws IOException {
        if(baseURI!=null)
            RestAssured.baseURI = baseURI+"/"+getApiInfo().get("test_apiVersion")+"/"+getApiInfo().get("test_language");
        else
            RestAssured.baseURI = propertyData.get("test_qaURL")+"/"+propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language");
    }

}
