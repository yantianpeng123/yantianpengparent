package com.yantianpeng.EamilUtil;

import com.yantianpeng.vo.SendEmail;

import java.util.Properties;

/**

 * @Description:    发送邮件工具类

 * @Author:        yantianpeng

 * @CreateDate:     2018/10/24 下午11:42


 */
public class SendEmailUtils {

    public static void sendEmail(SendEmail sendEmail)throws Exception{
        //1.配置参数用于服务器连接；
        Properties properties =new Properties();
        properties.setProperty("mail.transport.protocol","smtp");//使用参数协议（JavaMail规范要求）；
        properties.setProperty("mail.smtp.host",sendEmail.getSendEmailSMTPHost());//发件人邮箱SMTP服务器地址；
        properties.setProperty("mail.smtp.auth", "true");//需要请求认证

    }
}
