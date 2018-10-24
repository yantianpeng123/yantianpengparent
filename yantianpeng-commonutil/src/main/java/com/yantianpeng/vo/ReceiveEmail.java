package com.yantianpeng.vo;

import lombok.Data;

/**
 * 收件人
 */
@Data
public class ReceiveEmail {
    /**
     * 收件人昵称或者名字
     */
    private String receiveEamilName;
    /**
     * 收件人邮箱
     */
    private String receiveEmailAccount;
}
