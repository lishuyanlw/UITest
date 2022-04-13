package com.tsc.api.apiBuilder;

import com.tsc.api.util.PropertyReader;
import com.tsc.pages.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

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
//        if(baseURI!=null)
//            RestAssured.baseURI = baseURI+"/"+getApiInfo().get("test_apiVersion")+"/"+getApiInfo().get("test_language");
//        else
//            RestAssured.baseURI = propertyData.get("test_qaURL")+"/"+propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language");
    	
    	if(baseURI!=null)
            RestAssured.baseURI = baseURI+"/";
        else
            RestAssured.baseURI = propertyData.get("test_qaURL")+"/";
    }

    /**
     * This method makes POST call to api after authentication
     * @param - JSONObject - config : input Json object that is needed for POST call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response postApiCallResponseAfterAuthenticationFromJSON(JSONObject config, String apiEndPoint, String accessToken){
        if(config==null){
            return RestAssured.given().header("Authorization",
                            "Bearer " + accessToken).
                    header("Content-Type","application/json").
                    when().
                    post(apiEndPoint).
                    then().
                    extract().response();
        }
        else{
            return RestAssured.given().header("Authorization",
                            "Bearer " + accessToken).
                    header("Content-Type","application/json").
                    when().body(config.toString()).
                    post(apiEndPoint).
                    then().
                    extract().response();
        }
    }

    /**
     * This method makes GET call to api after authentication
     * @param - Map<String,Object> - config : input params that are needed for GET call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    public Response getApiCallResponseAfterAuthentication(Map<String, Object> config, String apiEndPoint, String accessToken){
        if(config!=null) {
            return RestAssured.given().header("Authorization",
                            "Bearer " + accessToken).
                    header("Content-Type","application/json").
                    when().queryParams(config).
                    get(apiEndPoint);
        }
        else {
            Response response = RestAssured.given().header("Authorization",
                            "Bearer " + accessToken).
                    header("Content-Type","application/json").
                    when().
                    get(apiEndPoint);

            return response;
        }
    }

}
