package com.yantianpeng;

import com.yantianpeng.common.AllAdressPeoperties;

import java.util.*;

public class Test {
    private static Map<String,String> propertiesMap;
    public static void main(String[] args) {
//
//        Map<String, String> stringStringMap = test01();
//        Iterator<Map.Entry<String, String>> iterator = stringStringMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey()+" "+next.getValue());
//        }

        String reqURL = new AllAdressPeoperties().getProperties("ReqURL");
        String appKey = new AllAdressPeoperties().getProperties("AppKey");
        String eBusinessID = new AllAdressPeoperties().getProperties("EBusinessID");
        System.out.println(reqURL);
        System.out.println(appKey);
        System.out.println(eBusinessID);
    }

    /**
     *测试配置文件加载是可以读取到
     */
//    public static Map<String,String> test01(){
//        Properties properties =new Properties();
//        Map<String,String> result =new HashMap<>();
//       try{
//           InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("allAdressProperties.properties");
//           properties.load(in);
//           Enumeration<?> enumeration = properties.propertyNames();
//           while (enumeration.hasMoreElements()){
//              String   key = (String)enumeration.nextElement();
//              String  value =(String) properties.get(key);
//              result.put(key,value);
//           }
//       }catch (Exception ex){
//
//       }
//       propertiesMap =result;
//       return propertiesMap;
//    }
}

