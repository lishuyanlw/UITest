package com.tsc.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    /**
     * This method parses response from api to respective class type
     * @param - String - response : response returned from api
     * @param - Class<T> - returnClassType : generic class object for parsing response
     * @return - T - generic class object passed as input
     */
    public static <T> T getResponse(String response, Class<T> returnClassType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response,returnClassType);
    }

    /**
     * This method parses response from api to respective POJO object
     * @param - String - response : response returned from api
     * @param - TypeReference<T> - typeReference : generic type reference object for output POJO class
     * @return - T - generic class object passed as input
     */
    public static <T> T getResponseObject(String response, TypeReference<T> typeReference){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response,typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
