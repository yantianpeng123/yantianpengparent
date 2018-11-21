package com.yantianpeng.common.KuaiDiNiao;

/**

* @Description:    快递鸟请求接口指令

* @Author:        yantianpeng

* @CreateDate:     2018/11/19 下午9:15


*/
public class   RequestType {

    /**
     * 预约取件
     */
    public   static final String AppointmentTake = "1001";

    /**
     * 电子面单接口
     */
    public static final String ElectronicSurface = "1007";
    /**
     * 订单取消接口
     */
    public static final String CanceOrder ="1147";
    /**
     *单号余量查询
     */
    public static final String OrderCount = "1127";
    /**
     * 客户号申请
     */
    public static final String ApplyCustomerId = "1107";
    /**
     * 客户号推送
     */
    public static final String  CustomerPush = "1117";
    /**
     *实名认证接口
     */
    public static final String RealNameOrder = "1021";
    /**
     * 即时查询接口
     */
    public static final String NowTrackOrder = "1002";
    /**
     * 物流跟踪接口
     */
    public static final String LogisticsTrack = "1008";
    /**
     *轨迹推送接口
     */
    public static final String LogisticsPush = "101";
    /**
     * 单号识别
     */
    public static final String OrderIdentify = "2002";

}