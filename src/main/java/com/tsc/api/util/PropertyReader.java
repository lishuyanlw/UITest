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

    private static void loadProperty() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/gradle.properties"));
        properties.load(fileInputStream);
    }

    public static Map<String,String> getPropertyDataMap() throws IOException {
        loadProperty();
        for(Map.Entry<Object, Object> entry:properties.entrySet()){
            propertyData.put((String)entry.getKey(), (String)entry.getValue());
        }
        return propertyData;
    }
}
