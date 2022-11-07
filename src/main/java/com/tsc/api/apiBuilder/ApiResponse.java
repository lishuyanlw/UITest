package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.*;
import com.tsc.api.pojo.Product.edps;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import extentreport.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ApiResponse extends ApiConfigs {
	public static Map<String, String> apiProperty;

    public ApiResponse() throws IOException {
		apiProperty = this.getApiInfo();
	}

    /**
     * This method get api User session token for authenticated api calls
     * @param - String - userName for getting session key that is present in application
     * @param - String - password for username provided above
     * @param - String - apiKey value that is constant value provided
     * @param - String - grant_type that is set as password
     * @return - JSONObject that contains session key and other info
     */
    public org.json.JSONObject getApiUserSessionData(String userName, String password, String grant_type, String apiKey) throws IOException {
        setApiClient(apiProperty.get("test_qaURL"));
        //Api Call to get access token
        Response response = given().
                contentType("application/x-www-form-urlencoded").
                header("cache-control","no-cache").
                formParam("userName",userName).
                formParam("password",password).
                formParam("grant_type",grant_type).
                formParam("AppKey",apiKey).
                formParam("recaptchaRequired","false").
                when().post("/api/token").
                then().extract().response();

        org.json.JSONObject apiSessionInfo = new org.json.JSONObject();
        if(response.statusCode()==200){
            //Return object containing api access token and expiration time
            apiSessionInfo.put("access_token",response.jsonPath().get("access_token").toString());
            apiSessionInfo.put("refresh_token",response.jsonPath().get("refresh_token").toString());
            apiSessionInfo.put("customerEDP",response.jsonPath().get("customerEDP").toString());
            apiSessionInfo.put("refreshExpireInSeconds",response.jsonPath().get("refreshExpireInSeconds").toString());
            apiSessionInfo.put("expiration_time",response.jsonPath().get("'.expires'").toString());
        }else{
            System.out.println("User status code: "+response.statusCode());
            new ExtentTestManager().reportLogFail("Session Info for api is not fetched as expected..Run again!!");
        }

        return apiSessionInfo;
    }

    /**
     * This method get api App session token for authenticated api calls
     * @param - String - userName for getting session key that is present in application
     * @param - String - password for username provided above
     * @param - String - grant_type that is set as password
     * @param - String - access token from user authentication
     * @return - JSONObject that contains session key and other info
     */
    public org.json.JSONObject getApiAppSessionData(String userName, String password, String grant_type,String access_token) throws IOException {
        setApiClient(apiProperty.get("test_qaURL"));
        //Api Call to get access token
        Response response = given().
                contentType("application/x-www-form-urlencoded").
                header("Authorization",
                        "Bearer " + access_token).
                formParam("userName",userName).
                formParam("password",password).
                formParam("grant_type",grant_type).
                when().post("/api/token").
                then().extract().response();

        org.json.JSONObject apiSessionInfo = new org.json.JSONObject();
        if(response.statusCode()==200){
            //Return object containing api access token and expiration time
            apiSessionInfo.put("access_token",response.jsonPath().get("access_token").toString());
            apiSessionInfo.put("refresh_token",response.jsonPath().get("refresh_token").toString());
            apiSessionInfo.put("customerEDP",response.jsonPath().get("customerEDP").toString());
            apiSessionInfo.put("refreshExpireInSeconds",response.jsonPath().get("refreshExpireInSeconds").toString());
            apiSessionInfo.put("expiration_time",response.jsonPath().get("'.expires'").toString());
        }else{
            System.out.println("App Status code: "+response.statusCode());
            new ExtentTestManager().reportLogFail("Session Info for api is not fetched as expected..Run again!!");
        }

        return apiSessionInfo;
    }

    /**
     * This method is to fetch account details for a user using EDP
     * @param - String - customerEDP
     */
    public AccountResponse getUserDetailsFromCustomerEDP(String customerEDP, String accessToken){
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/" + customerEDP;
        Response response = getApiCallResponseAfterAuthentication(null,apiEndPoint,accessToken);
        if(response.getStatusCode()==200)
            return JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        else
            return null;
    }



}
