package com.tsc.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
    public static Map<String,String> propertyData = new HashMap<>();
    public static Properties properties = null;

    /**
     * This method is to load all properties define in gradle.properties file
     * @param - no param
     * @return - void
     */
    private static void loadProperty() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/gradle.properties"));
        properties.load(fileInputStream);
    }

    /**
     * This method is to return properties as map
     * @param - no param
     * @return - void
     */
    public static Map<String,String> getPropertyDataMap() throws IOException {
        loadProperty();
        for(Map.Entry<Object, Object> entry:properties.entrySet()){
            propertyData.put((String)entry.getKey(), (String)entry.getValue());
        }
        return propertyData;
    }
}
