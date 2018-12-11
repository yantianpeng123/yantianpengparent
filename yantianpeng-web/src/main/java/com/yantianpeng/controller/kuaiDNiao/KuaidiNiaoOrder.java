package com.yantianpeng.controller.kuaiDNiao;

import com.yantianpeng.common.AllAdressPeoperties;
import com.yantianpeng.common.KuaiDiNiao.RequestType;
import com.yantianpeng.response.BaseResponse;
import com.yantianpeng.service.kuaiDiNiao.KuaiDiNiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class KuaidiNiaoOrder {
    @Autowired
    private KuaiDiNiaoService kuaiDiNiaoService;

    /**
     * 即时查询接口返回
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/NowTrackOrder")
    public BaseResponse NowTrackOrder(HttpServletRequest request)throws Exception{
        String param = new String(request.getParameter("params").getBytes("iso-8859-1"), "utf-8");
        BaseResponse nowTrackOrder = kuaiDiNiaoService.NowTrackOrder(param,
                new AllAdressPeoperties().getProperties("NowTrackOrderURL"), new RequestType().NowTrackOrder);
        return nowTrackOrder;
    }

    /**
     * 单号识别
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/OrderIdentify")
    public BaseResponse OrderIdentify(HttpServletRequest request) throws Exception{
        String param = new String(request.getParameter("params").getBytes("iso-8859-1"), "utf-8");
        BaseResponse response = kuaiDiNiaoService.OrderIdentify(param,
                new AllAdressPeoperties().getProperties("OrderIdentifyUrl"), new RequestType().OrderIdentify);
        return response;
    }

    @RequestMapping("/AppointmentTake")
     public  BaseResponse AppointmentTake(HttpServletRequest request)throws Exception{
         String param = new String(request.getParameter("params").getBytes("iso-8859-1"), "utf-8");
         BaseResponse response = kuaiDiNiaoService.AppointmentTake(param,
                 new AllAdressPeoperties().getProperties("AppointmentTake_URl"), new RequestType().AppointmentTake);
         return response;
     }

     public void test01(){

     }

     public void test02(){

     }


     public void test03(){

     }
}
