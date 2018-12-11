package com.yantianpeng.G7Code;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AllAdressUtil {

    private Map<String ,String> propertiesMap;

    public AllAdressUtil(){
        Properties properties = new Properties();
        Map<String,String> result = new HashMap<>();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("allAdressProperties.properties");
        try {
            properties.load(resourceAsStream);
            Enumeration<?> enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String value = properties.getProperty(key);
                result.put(key,value);

            }
        }catch (Exception ex){

        }
        propertiesMap =result;
    }

    public String getProperties(String key){
        return propertiesMap.get(key).trim();
    }
}
