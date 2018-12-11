package com.yantianpeng.entity.kuaiDiaNiao;

import lombok.Data;

/**

* @Description:    发件/寄件人实体信息类

* @Author:        yantianpeng

* @CreateDate:     2018/11/29 下午4:17


*/
@Data
public class senderOrReciver {
    /**
     * 发件/寄件公司
     */
    private String  company;
    /**
     * 发件人/收件人姓名
     */
    private String name;
    /**
     * 发件人/收件人电话
     */
    private String tel;
    /**
     * 发件人/收件人手机
     */
    private String mobile;
    /**
     * 发件人/寄件人邮编
     */
    private String postCode;
    /**
     * 发件/收件地址省不要缺少省，直辖市请直接传(上海，北京，重庆，天津) 自治区（广西壮族自治区）
     */
    private String provinceName;
    /**
     * 发件/寄件市 不要少了市这个字段
     */
    private String cityName;
    /**
     * 发件/寄件地址县（不要缺少区或者县字段）
     */
    private String expAreaName;
    /**
     * 发件人详细地址
     */
    private String adress;
}
