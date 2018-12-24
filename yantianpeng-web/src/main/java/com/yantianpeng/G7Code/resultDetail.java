package com.yantianpeng.G7Code;

import lombok.Data;

import java.util.List;

/**

* @Description:    resultDetail细节处理

* @Author:        yantianpeng

* @CreateDate:     2018/12/14 下午2:17


*/
@Data
public class resultDetail {
    /**
     * 唯一标识
     */
   private String uuid;
    /**
     * 纬度
     */
    private  float lat;
    /**
     * 经度
     */
    private float lng;
    /**
     * 解析地址级别
     */
    private  int level;
    /**
     * 版图编码
     */
    private String typecode	;
    /**
     * 版图名称
     */
    private String typename	;
    /**
     *片区所属机构
     */
    private String   orgcode;
    /**
     * 所匹配到的片区信息
     */
    protected List<fencesDetail> fences;
}
