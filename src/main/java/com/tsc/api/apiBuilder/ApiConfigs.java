package com.tsc.api.apiBuilder;

import com.tsc.api.util.DataConverter;

import java.io.IOException;
import java.util.*;

public class ApiConfigs extends ApiClient{
    public Map<String,Object> inputMap = null;

    public ApiConfigs() throws IOException {
        super.setApiClient(null);
    }

    /**
     * This method is to set initial default configs for Product Search api
     * @param - String - keyword - search keyword for product
     * @param - String - dimension - dimension number for product
     * @param - int - outputPage - page number to be returned by api
     * @param - String - apiVersion - api version implemented to be used
     * @return - Map<String, Object> - map object containing all default configs
     */
    public Map<String, Object> getProductSearchByKeywordInputConfig(String keyword, String dimension, int outputPage, String apiVersion) {
        inputMap = new HashMap<>();
        inputMap.put("searchTerm", keyword);
//        inputMap.put("sortKey", "HighestPrice");
        
        if (dimension != null)
            inputMap.put("dimensions", Integer.parseInt(dimension));
        inputMap.put("page", outputPage);
        inputMap.put("pageSize", Integer.parseInt("100"));
        if (apiVersion.contains("v2"))
            inputMap.put("rd", true);
        else
            inputMap.put("rd", Integer.parseInt("1"));

        return inputMap;
    }

    /**
     *This methods forms a URL that can be directly invoked in browser
     * @param-String landinPage - landing page of application for url
     * @param-inputParameters - input Data Type for parameters that will be given in api call
     * @return-String - String url that can be invoked in browser
     */
    public <T> HashMap<String,String> getAPIURLForInputModuleAndParameterOrDefaultValues(String landingPage,List<List<String>> inputParameters,String inputParamType,String searchTerm){
        HashMap<String,String> hashMap = new HashMap<>();
        String parameterString = null;
        String apiBaseURL = System.getProperty("QaUrl");
        if(inputParamType.equalsIgnoreCase("default")){
            hashMap.put("dimension","0");
            hashMap.put("page","1");
            hashMap.put("pageSize","36");
            hashMap.put("sortKey","Featured Products");
            hashMap.put("searchTerm",searchTerm);
            for(Map.Entry<String,String> entry:hashMap.entrySet()){
                parameterString = parameterString == null ? entry.getKey() + "=" + entry.getValue() : parameterString + "&" + entry.getKey() + "=" + entry.getValue();
            }
            apiBaseURL=apiBaseURL+landingPage+parameterString;
            hashMap.put("url",apiBaseURL);
            return hashMap;
        }else if(inputParamType.equalsIgnoreCase("None")){
            apiBaseURL=apiBaseURL+landingPage+"searchTerm="+searchTerm;
            hashMap.put("url",apiBaseURL);
            hashMap.put("page","1");
            hashMap.put("sortKey","Featured Products");
            hashMap.put("pageSize","36");
            hashMap.put("searchTerm",searchTerm);
            return hashMap;
        }
        else{
            HashMap<String,String> parameterMap = new DataConverter().convertData(inputParameters,new HashMap<>());
            if(landingPage.toLowerCase().contains("productresult")){
                for(Map.Entry<String,String> entry:parameterMap.entrySet()){
                    if(entry.getKey().equalsIgnoreCase("sortKey")){
                        parameterString = parameterString == null ? entry.getKey() + "=" + entry.getValue().split(":")[0] : parameterString + "&" + entry.getKey() + "=" + entry.getValue().split(":")[0];
                        hashMap.put("sortKey",entry.getValue().split(":")[1]);
                    }else if(entry.getKey().equalsIgnoreCase("pageSize")){
                        parameterString = parameterString == null ? entry.getKey() + "=" + entry.getValue() : parameterString + "&" + entry.getKey() + "=" + entry.getValue();
                        hashMap.put("pageSize",entry.getValue());
                    }else
                        parameterString = parameterString == null ? entry.getKey() + "=" + entry.getValue() : parameterString + "&" + entry.getKey() + "=" + entry.getValue();
                }
                apiBaseURL=apiBaseURL+landingPage+parameterString;
                hashMap.put("url",apiBaseURL);
                return hashMap;
            }
        }
        return null;
    }
}
