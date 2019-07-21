package com.yantianpeng.G7Code.G7CodeTest;
import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * api 测试类
 * Created by chenjz on 2017/10/20.
 */
public class ApiTest {
    // 接口账号
    private static final String  APP_KEY = "qykd_adminTest";
    private static final String  APP_SECRET = "2e5d74cf8403b7f61966fab2f7b0abdd";

    // 接口调用地址
    private static final String ROUTERURL="http://g7s.api.huoyunren.com";

    /** 调用方法 */
    private static final String DEFINEDMETHOD = "map.api.areaMatch";

    public static void main(String[] args) {
        apiTest();

    }

    public  static void apiTest() {
        Map<String,String> jsonparams =  new HashMap<String,String>();
        String adress ="上海上海市青浦区菘泽大道7508号7";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //添加请求参数
        jsonparams.put("adress",adress);
        jsonparams.put("uuid", uuid);
        jsonparams.put("type","51110");
        //将map转换为jsonstr
        Gson gs = new Gson();
        String jsonStr = gs.toJson(jsonparams);
        Map<String,Object> params = new HashMap<String, Object>();

        params.put("data", jsonStr);

        long time0 = new Date().getTime();		// 接口调用开始时间

        Result result = HttpService.callFuntion(ROUTERURL, APP_KEY, DEFINEDMETHOD, APP_SECRET, params);

        long usedTime = new Date().getTime() - time0; // 得出的时间间隔是毫秒

        System.out.println("耗时：" + usedTime);

        // 查询类接口
        String data = jsonparams.toString();
        String backresult = result.toString();
        System.out.println(data + '\n' + backresult);
    }
}

