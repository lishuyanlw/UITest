package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.BrandResponse;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public class BrandAPI extends ApiClient {
    public BrandAPI() throws IOException { super(); }

    public List<BrandResponse> getProductListForDimensionId(String dimensionId){
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/brand?dimension="+dimensionId;
        Response response = this.getApiCallResponse(null,apiEndPoint);
        if(response.getStatusCode()==200){
            List<BrandResponse> brandResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<List<BrandResponse>>() {});
            return brandResponse;
        }
        else
            return null;
    }
}
