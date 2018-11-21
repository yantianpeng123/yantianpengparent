package com.yantianpeng.common;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**

* @Description:    获取配置文件的方法

* @Author:        yantianpeng

* @CreateDate:     2018/11/19 下午10:27


*/
public class AllAdressPeoperties {

    private  Map<String,String> propertiesMap;

    public   AllAdressPeoperties(){
        Properties properties =new Properties();
        Map<String,String> result =new HashMap<>();
        try{
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("allAdressProperties.properties");
            properties.load(in);
            Enumeration<?> enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()){
                String   key = (String)enumeration.nextElement();
                String  value =(String) properties.get(key);
                result.put(key,value);
            }
        }catch (Exception ex){

        }
        propertiesMap =result;
    }

    /**
     * 获取配置文件的value
     * @param name
     * @return
     */
    public String getProperties(String name){
        return propertiesMap.get(name);
    }
}
