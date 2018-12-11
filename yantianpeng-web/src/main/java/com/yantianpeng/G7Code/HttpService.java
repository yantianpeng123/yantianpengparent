package com.yantianpeng.G7Code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**

* @Description:    Http调用方法

* @Author:        yantianpeng

* @CreateDate:     2018/11/27 下午9:43


*/
public class HttpService {

    public static Result cllFuntion(String routerUrl, String appkey, String method, String appsecret, Map<String,Object> params){
        params = ParamUtil.dealParams(params,method,appkey,appsecret);
        try{
            return dealData(params,routerUrl);
        }catch (Exception ex){
            Result result =new Result();
            result.setCode(10001);
            result.setMessage(ex.getMessage());
            result.setData("");
            result.setParams(params);
            return result;
        }

    }


    private static Result dealData(Map<String,Object> params,String routerUrl){
        Result result =new Result();
        String data =null;
        try{
             data = HttpSyncService.sendPost(routerUrl, params);
            JSONObject jsonObject = JSON.parseObject(data);
            if(jsonObject!=null && jsonObject.containsKey("code")
                    ||jsonObject.containsKey("data")||jsonObject.containsKey("message")){
                result.setCode(jsonObject.get("code")==null?0:(int)Float.parseFloat(jsonObject.get("code").toString()));
                result.setData(jsonObject.get("data"));
                result.setMessage(jsonObject.get("message")==null?"null":jsonObject.get("message").toString());
            }else{
                result.setData(data);
                result.setMessage("调用成功");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result.setCode(10001);
            result.setData(data);
            result.setMessage("参数异常，请检查参数");
        }
        return  result;
    }
}
