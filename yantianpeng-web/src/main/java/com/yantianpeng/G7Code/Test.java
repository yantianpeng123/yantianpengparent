package com.yantianpeng.G7Code;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**

* @Description:    G7测试类

* @Author:        yantianpeng

* @CreateDate:     2018/11/27 下午10:05


*/
public class Test {


    public static void main(String[] args) throws Exception{
        String routerUrl ="http://demo.api.g7s.chinawayltd.com/interface/index.php";
        String appkey ="qykd_adminTest";
        String method ="map.api.areaMatch";
        String appsecret="2e5d74cf8403b7f61966fab2f7b0abdd";
        Map<String,Object> jsonMap = new HashMap<>();
        String adress ="上海市青浦区崧泽大道7508号";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        jsonMap.put("address",adress);
        jsonMap.put("uuid",uuid);
        jsonMap.put("type","51110");
        Map<String,Object> params = new HashMap<>();
        String json = JSON.toJSONString(jsonMap);
//        String encode = URLEncoder.encode(json, "utf-8");
//        params.put("data",encode);
        params.put("data",json);
      // params.put("data",dataSb.toString());
        new HttpService().cllFuntion(routerUrl,appkey,method,appsecret,params);
    }



}
