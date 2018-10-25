package com.yantianpeng.entity;

import lombok.Data;

/**

* @Description:    基础返回类

* @Author:        yantianpeng

* @CreateDate:     2018/10/25 下午10:12


*/
@Data
public class BaseResponse {
    /**
     * 返回状态码
     */
    private int code;
    /**
     * 返回成功或者失败
     */
    private boolean success;
    /**
     *返回状态信息
     */
    private String message;
}
