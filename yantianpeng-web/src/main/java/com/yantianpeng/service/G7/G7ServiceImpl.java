package com.yantianpeng.service.G7;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yantianpeng.G7Code.*;
import com.yantianpeng.common.AllAdressPeoperties;
import com.yantianpeng.entity.G7.G7Entity;
import com.yantianpeng.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2019/5/18 下午11:14


*/
@Service
public class G7ServiceImpl implements G7Service {
    /**
     *  地址解析接口
     * @param g7Entity
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse G7mapapigeoSearch(G7Entity g7Entity) throws Exception {
        BaseResponse response =new BaseResponse();
        //先判断是否为空
        if(null==g7Entity.getProvice()||"".equals(g7Entity.getProvice())){
            response.setSuccess(false);
            response.setErrorCode("300");
            response.setNotes("省不能为空");
            return response;
        }
        if(null==g7Entity.getCity()||"".equals(g7Entity.getCity())){
            response.setSuccess(false);
            response.setErrorCode("300");
            response.setNotes("市不能为空");
            return response;
        }
//        if (null==g7Entity.getAare()||"".equals(g7Entity.getAare())){
//            response.setSuccess(false);
//            response.setErrorCode("300");
//            response.setNotes("区不能为空");
//            return response;
//        }
       // if(null==g7Entity.getProvice()||"".equals(g7Entity.getProvice()))g7Entity.setProvice("");
        //if(null==g7Entity.getCity()||"".equals(g7Entity.getProvice())) g7Entity.setCity("");

        if(null==g7Entity.getAare()||"".equals(g7Entity.getAare())) g7Entity.setAare("");

        if(null==g7Entity.getAdress()||"".equals(g7Entity.getAdress())){
            response.setSuccess(false);
            response.setErrorCode("300");
            response.setNotes("详细地址不能为空");
            return response;
        }
        Map<String,Object> jsonMap = new HashMap<>();
        String adress=g7Entity.getProvice()+g7Entity.getCity()+g7Entity.getAare()+g7Entity.getAdress();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        jsonMap.put("address",adress);
        jsonMap.put("uuid",uuid);
        jsonMap.put("type","QYKD01");
        Map<String,Object> params = new HashMap<>();
        String json = JSON.toJSONString(jsonMap);
        params.put("data",json);

        Result result = new HttpService().cllFuntion(
                new AllAdressPeoperties().getProperties("G7_interfaceurl"),new AllAdressPeoperties().getProperties("G7_appkey")
                     ,new AllAdressPeoperties().getProperties("G7_orgcode"), new AllAdressPeoperties().getProperties("G7_appsecret"), params);

        if(0!=result.getCode()) {
            response.setNotes("接口调用失败");
            response.setErrorCode("300");
            response.setSuccess(false);
            return response;
        }else{
            List list =new ArrayList<Result>();
            String string = result.getData().toString();
            JSONObject jsonObject = JSONObject.parseObject(string);
            ResultData resultData =  (ResultData) JSONObject.parseObject(string,ResultData.class);
            if(resultData.getError().isEmpty()){
                list.add(resultData);
            }
            response.setData(list);
            response.setErrorCode("200");
            response.setSuccess(true);
            return response;
        }
    }
}
