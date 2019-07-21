package com.yantianpeng.controller.G7;

import com.yantianpeng.entity.G7.G7Entity;
import com.yantianpeng.response.BaseResponse;
import com.yantianpeng.service.G7.G7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**

* @Description:    G7接口

* @Author:        yantianpeng

* @CreateDate:     2019/5/19 上午12:18


*/
@RestController
public class G7Controller {

    @Autowired
    private G7Service g7Service;

    @PostMapping("/G7mapapigeoSearch")
    public BaseResponse G7mapapigeoSearch(G7Entity g7Entity)throws Exception{
        BaseResponse response =new BaseResponse();
        try{
            response = g7Service.G7mapapigeoSearch(g7Entity);
        }catch (Exception ex){
            response.setSuccess(false);
            response.setErrorCode("500");
            response.setNotes("系统异常");
        }
        return response;
    }
}
