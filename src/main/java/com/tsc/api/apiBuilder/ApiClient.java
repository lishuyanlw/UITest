package com.tsc.api.apiBuilder;

import com.tsc.api.util.PropertyReader;
import com.tsc.pages.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    protected Response postApiCallResponseAfterAuthenticationFromJSON(org.json.simple.JSONObject config, String apiEndPoint, String accessToken){
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


    /**************************************************************************************
     *
     * Common Methods used for API call
     *
     *************************************************************************************/
    /**
     * This method makes GET call to api
     * @param - Map<String,Object> - config : input params that are needed for GET call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response getApiCallResponse(Map<String,Object> config, String apiEndPoint){
        if(config!=null) {
            return RestAssured.given().
                    when().params(config).header("Content-Type","application/json").
                    get(apiEndPoint);
        }
        else {
            return RestAssured.given().
                    when().header("Content-Type","application/json").
                    get(apiEndPoint);
        }
    }

    /**
     * This method makes UPDATE call to api after authentication
     * @param - JSONObject - config : input Json object that is needed for UPDATE call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response updateApiCallResponseAfterAuthenticationFromJSON(JSONObject config, String apiEndPoint, String accessToken){
        return RestAssured.given().header("Authorization",
                        "Bearer " + accessToken).
                header("Content-Type","application/json").
                when().body(config.toString()).
                put(apiEndPoint).
                then().
                extract().response();
    }

    /**
     * This method makes DELETE call to api after authentication
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response deleteApiCallResponseAfterAuthentication(String apiEndPoint, String accessToken){
        return RestAssured.given().header("Authorization",
                        "Bearer " + accessToken).
                header("Content-Type","application/json").
                when().
                delete(apiEndPoint).
                then().
                extract().response();
    }

    /**
     * This method makes DELETE api call after authentication
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response deleteCreditCardFromUserAfterAuthentication(String apiEndPoint, String accessToken){
        return RestAssured.given().header("Authorization",
                        "Bearer " + accessToken).
                header("Content-Type","application/json").
                when().
                delete(apiEndPoint);
    }

    /**
     * This method makes PUT api call after authentication
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    protected Response updateCreditCardDetailsForUserAfterAuthentication(JSONObject config, String apiEndPoint, String accessToken){
        return RestAssured.given().header("Authorization",
                        "Bearer " + accessToken).
                header("Content-Type","application/json").
                when().body(config).
                put(apiEndPoint);
    }

    /**
     * This method is to set initial default configs for Product Search api
     * @param - String - keyword - search keyword for product
     * @param - String - dimension - dimension number for product
     * @param - int - outputPage - page number to be returned by api
     * @param - String - apiVersion - api version implemented to be used
     * @return - Map<String, Object> - map object containing all default configs
     */
    protected Map<String, Object> getProductSearchByKeywordInputConfig(String keyword, String dimension, int outputPage, String pageSize, String apiVersion) {
        Map<String,Object> inputMap = new HashMap<>();
        inputMap.put("searchTerm", keyword);

        if (dimension != null)
            inputMap.put("dimensions", Integer.parseInt(dimension));
        inputMap.put("page", outputPage);
        if(pageSize==null)
            inputMap.put("pageSize", Integer.parseInt("100"));
        else
            inputMap.put("pageSize", Integer.parseInt(pageSize));
        if (apiVersion.contains("v2"))
            inputMap.put("rd", true);
        else
            inputMap.put("rd", Integer.parseInt("1"));

        return inputMap;
    }

}
