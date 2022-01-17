package com.tsc.api.apiBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
}
