package com.yantianpeng.vo;

import lombok.Data;

import java.util.List;

/**
 * 发件人实体
 */
@Data
public class SendEmail {
    /**
     * 发件人服务器地址
     */
    private String sendEmailSMTPHost;
    /**
     * 发件人服务邮箱
     */
    private String sendEamilAdrerss;
    /**
     * 发件人邮箱密码或者授权码
     */
    private String sendEmailPassword;
    /**
     * 发件人姓名
     */
    private String sendEmailName;
    /**
     * 邮件主题
     */
    private String sendEmailTheme;
    /**
     * 邮件正文
     */
    private String sendEamilText;
    /**
     * 收件人集合
     */
    private List<ReceiveEmail> receiveEmailList;
}
