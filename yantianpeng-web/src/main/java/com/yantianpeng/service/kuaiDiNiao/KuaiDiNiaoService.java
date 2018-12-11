package com.yantianpeng.service.kuaiDiNiao;


import com.yantianpeng.response.BaseResponse;

public interface KuaiDiNiaoService {
    /**
     * 即时查询接口
     * @param JsonDate
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    BaseResponse NowTrackOrder(String JsonDate, String url, String code) throws Exception;

    /**
     * 单号识别功能
     *
     * @param JsonData
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    BaseResponse OrderIdentify(String JsonData,String url,String code) throws Exception;

    /**
     * 单号余量查询接口
     * @param JsonData
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    BaseResponse OrderCount(String JsonData,String url,String code) throws  Exception;

    /**
     * 客户号申请
     * @param JsonData
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    BaseResponse ApplyCustomerId (String JsonData,String url,String code)throws Exception;

    /**
     * 预约取件接口
     * @param JsonDate
     * @param url
     * @param code
     * @return
     * @throws Exception
     */
    BaseResponse AppointmentTake(String JsonDate,String url,String code) throws Exception;
}
