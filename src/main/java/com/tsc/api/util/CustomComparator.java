package com.tsc.api.util;

import java.util.Comparator;
import java.util.Map;

public class CustomComparator {
    public static Comparator<Map<String,Object>> nameComparator = new Comparator<Map<String, Object>>() {
        @Override
        public int compare(Map<String, Object> objectOne, Map<String, Object> objectTwo) {
            return objectOne.get("productName").toString().compareTo(objectTwo.get("productName").toString());
        }
    };

    public static Comparator<Map<String,Object>> styleComparator = new Comparator<Map<String, Object>>() {
        @Override
        public int compare(Map<String, Object> objectOne, Map<String, Object> objectTwo) {
            if(objectOne.get("productStyle")!=null && objectTwo.get("productStyle")!=null){
                return objectOne.get("productStyle").toString().compareTo(objectTwo.get("productStyle").toString());
            }else
                return 1;
        }
    };

    public static Comparator<Map<String,Object>> sizeComparator = new Comparator<Map<String, Object>>() {
        @Override
        public int compare(Map<String, Object> objectOne, Map<String, Object> objectTwo) {
            if(objectOne.get("productSize")!=null && objectTwo.get("productSize")!=null){
                return objectOne.get("productSize").toString().compareTo(objectTwo.get("productSize").toString());
            }else
                return 1;
        }
    };
}
