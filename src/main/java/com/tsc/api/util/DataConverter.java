package com.tsc.api.util;

import java.util.HashMap;
import java.util.List;

public class DataConverter {
    /**
     *This method converts provided datatype to desired datatype
     * @param-inputData - input Data that is to be converted
     * @param-returnType - return type for data
     * @return-Generic datatype - Generic data type that is returned by function on basis of input return type
     */
    public <T> T convertData(List<List<String>> inputData,T returnType){
        if(returnType.getClass().getName().toLowerCase().contains("map")){
            HashMap<String,String> hashMap = new HashMap<>();
            for(List<String> data:inputData){
                hashMap.put(data.get(0),data.get(1));
            }
            return (T) hashMap;
        }

        return null;
    }
}
