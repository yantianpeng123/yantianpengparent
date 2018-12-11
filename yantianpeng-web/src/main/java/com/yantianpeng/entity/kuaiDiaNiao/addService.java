package com.yantianpeng.entity.kuaiDiaNiao;

import lombok.Data;

/**

* @Description:    z增值服务类

* @Author:        yantianpeng

* @CreateDate:     2018/11/29 下午4:36


*/
@Data
public class addService {
    /**
     * 增值服务名称
     */
    private String name;
    /**
     * 增值服务值
     */
    private String value;
    /**
     * 客户标示
     */
    private String CustomerID;
}
