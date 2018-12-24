package com.yantianpeng.G7Code;

import lombok.Data;

/**

* @Description:    错误参数描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/14 下午2:41


*/
@Data
public class errorDeatil {
    /**
     * 错误信息提示
     */
    private String messgae;
    /**
     *错误信息代码
     */
    private int code;
    /**
     * 具体错误的地地址信息
     */
    private String params;
}
