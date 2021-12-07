package com.tsc.api.apiBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiConfigs extends ApiClient{
    public Map<String,Object> inputMap = null;

    public ApiConfigs() throws IOException {
        super.setApiClient(null);
    }

    public Map<String, Object> getProductSearchByKeywordInputConfig(String keyword, String dimension, String outputPage, String apiVersion) {
        inputMap = new HashMap<>();
        inputMap.put("searchTerm", keyword);
        if (dimension != null)
            inputMap.put("dimensions", Integer.parseInt(dimension));
        if (outputPage == null)
            inputMap.put("page", 1);
        else
            inputMap.put("page", Integer.parseInt(outputPage));
        inputMap.put("pageSize", Integer.parseInt("36"));
        if (apiVersion.contains("v2"))
            inputMap.put("rd", true);
        else
            inputMap.put("rd", Integer.parseInt("1"));

        return inputMap;
    }
}
