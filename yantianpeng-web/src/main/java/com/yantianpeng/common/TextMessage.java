package com.yantianpeng.common;

import lombok.Data;

@Data
public class TextMessage {

  private String  ToUserName;//	开发者微信号
    private String  FromUserName;//	发送方帐号（一个OpenID）
    private Long CreateTime;//	消息创建时间 （整型）
    private String  MsgType;//	消息类型，文本为text
    private String Content;//	文本消息内容
    private String MsgId;//	消息id，64位整型
}
