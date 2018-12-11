package com.yantianpeng.service.kuaiDiNiao;

import com.alibaba.fastjson.JSON;
import com.yantianpeng.common.KuaiDiNiao.HttpclientSend;
import com.yantianpeng.response.BaseResponse;
import com.yantianpeng.response.KuaiDiNiao.OrderIdentify;
import com.yantianpeng.response.KuaiDiNiao.TrackEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KuaiDiNiaoserviceImpl implements KuaiDiNiaoService{
    @Override
    public BaseResponse NowTrackOrder(String JsonDate, String url, String code) throws Exception {
        BaseResponse response = new BaseResponse();
        try{
            String sendPost = HttpclientSend.sendPost(JsonDate, url, code);
            TrackEntity sen = JSON.parseObject(sendPost,TrackEntity.class);
            if(sen.isSuccess()){
                response.setErrorCode("200");
                response.setSuccess(sen.isSuccess());
                List<TrackEntity> list = new ArrayList<>();
                list.add(sen);
                response.setData(list);
                response.setNotes("查询成功!");
            }else{
                response.setErrorCode("200");
                response.setSuccess(sen.isSuccess());
                List<TrackEntity> list = new ArrayList<>();
                list.add(sen);
                response.setData(list);
                response.setNotes(sen.getReason());
            }

        }catch (Exception ex){
            response.setNotes("请求失败");
            response.setSuccess(false);
            response.setErrorCode("500");
        }

        return response;
    }

    @Override
    public BaseResponse OrderIdentify(String JsonData, String url, String code) throws Exception {
        BaseResponse response = new BaseResponse();
        try{
            String sendPost = HttpclientSend.sendPost(JsonData, url, code);
            OrderIdentify orderIdentify = JSON.parseObject(sendPost, OrderIdentify.class);
            List<OrderIdentify> list = new ArrayList<>();
            System.out.println(orderIdentify.getShippers().isEmpty());
            if(orderIdentify.getShippers().isEmpty()){
                response.setNotes("单号识别失败");
                response.setErrorCode("300");
                response.setSuccess(false);
            }else{
                list.add(orderIdentify);
                response.setData(list);
                response.setErrorCode("200");
                response.setSuccess(true);
                response.setNotes("单号识别成功");
            }
        }catch (Exception ex){
            response.setNotes("系统异常!");
            response.setSuccess(false);
            response.setErrorCode("500");
        }
         return response;
    }

    /**
     * 单号余量查询接口
     * @param JsonData
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse OrderCount(String JsonData, String url, String code) throws Exception {
        BaseResponse response = new BaseResponse();
        try{
            String sendPost = HttpclientSend.sendPost(JsonData, url, code);

        }catch (Exception ex){

        }
        return  response;
    }

    /**
     * 客户号申请
     * @param JsonData
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse ApplyCustomerId(String JsonData, String url, String code) throws Exception {
        BaseResponse response = new BaseResponse();
    try{
        String sendPost = HttpclientSend.sendPost(JsonData, url, code);

    }catch (Exception ex){

    }
        return response;
    }

    /**
     * 预约取件
     * @param JsonDate
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse AppointmentTake(String JsonDate, String url, String code) throws Exception {
        BaseResponse response = new BaseResponse();
        try{
            String sendPost = HttpclientSend.sendPost(JsonDate, url, code);
        }catch (Exception ex){

        }
        return response;
    }
}
