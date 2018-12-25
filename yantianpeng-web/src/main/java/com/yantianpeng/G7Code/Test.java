package com.yantianpeng.G7Code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
      //  String routerUrl ="http://demo.api.g7s.chinawayltd.com/interface/index.php";
        String routerUrl ="http://g7s.api.huoyunren.com/interface/index.php";
        String appkey ="qykd_adminTest";
        String method ="map.api.areaMatch";
        String appsecret="2e5d74cf8403b7f61966fab2f7b0abdd";
        Map<String,Object> jsonMap = new HashMap<>();
      //  String adress ="河南省周口市鹿邑县";
       // String adress ="广东省佛山市禅城区大沙工业区大道四路2号美嘉装饰材料中心F馆二层8号";
       // String adress="上海上海市青浦区崧泽大道7508号";
        //String adress ="重庆市.重庆市.九龙坡区. 客服 重庆市九龙坡区石桥铺渝高C座7-2（办事处许冬梅）";
        String adress ="上海市杨浦区邯郸路660号宝大祥青少年购物中心1楼安奈儿专柜";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        jsonMap.put("address",adress);
        jsonMap.put("uuid",uuid);
        jsonMap.put("type","QYKD01");
        Map<String,Object> params = new HashMap<>();
        String json = JSON.toJSONString(jsonMap);
        params.put("data",json);
      // params.put("data",dataSb.toString());
        Result result = new HttpService().cllFuntion(routerUrl, appkey, method, appsecret, params);
        int code = result.getCode();
       String string = result.getData().toString();

       JSONObject jsonObject = JSONObject.parseObject(string);
        ResultData resultData =  (ResultData) JSONObject.parseObject(string,ResultData.class);

       System.out.println(resultData.getResult().isEmpty());
       if(resultData.getError().isEmpty()){
           for (resultDetail data: resultData.getResult()) {
               for (fencesDetail fencesDetail :data.fences) {
                   System.out.println(fencesDetail.getAreacode());
                   System.out.println(fencesDetail.getAreaname());
               }
           }
       }
        JSONArray result1 = (JSONArray) jsonObject.get("result");
        JSONArray error  =  (JSONArray) jsonObject.get("error");
        System.out.println(result.getData().toString());
    }



}
