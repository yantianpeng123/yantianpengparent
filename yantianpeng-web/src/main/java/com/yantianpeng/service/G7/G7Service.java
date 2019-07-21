package com.yantianpeng.service.G7;

import com.yantianpeng.entity.G7.G7Entity;
import com.yantianpeng.response.BaseResponse;

/**

* @Description:    G7

* @Author:        yantianpeng

* @CreateDate:     2019/5/18 下午11:10


*/
public interface G7Service {
    /**
     * 地址解析接口
     * @param g7Entity
     * @return
     * @throws Exception
     */
    BaseResponse G7mapapigeoSearch(G7Entity g7Entity) throws Exception;
}
