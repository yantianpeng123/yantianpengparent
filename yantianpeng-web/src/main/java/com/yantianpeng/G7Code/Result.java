package com.yantianpeng.G7Code;

import lombok.Data;

import java.util.Map;

/**

* @Description:   请求参数处理

* @Author:        yantianpeng

* @CreateDate:     2018/11/27 下午9:44


*/
@Data
public class Result {
    /**
     * 调用状态码接口调用状态码，0：代表成功；非0：有错误
     */
    private int code;
    /**
     * 调用不成功描述 当code =0 为空
     */
    private String message;
    /**
     *
     */
    private Map<String,Object> params;
    /**
     * 接口调用返回结果 当code非0时为空，具体参数需要看接口说明。
     */
    private Object data;
}
