package com.yantianpeng.EamilUtil;

import com.yantianpeng.vo.ReceiveEmail;
import com.yantianpeng.vo.SendEmail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        /**
         * 开启ssl安全认证：某些邮箱服务器要求SMTP连接需要使用ssl安全认证，（为了提高安全性，=邮箱支持ssl连接，也可以自己开启）
         * SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
         *         //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
         *         //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
         *
         */

        final String SMTPPORT="465";
        properties.setProperty("mail.smtp.port",SMTPPORT);
        properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallbac","false");
        properties.setProperty("mail.smtp.socketFactory.port",SMTPPORT);
        //2.根据配置获取绘画对象，用于和邮件服务器交互。
        Session session = Session.getInstance(properties);
        session.setDebug(true);//开启debug模式。可以查看详细的日志信息
        MimeMessage message = createMessage(session, sendEmail);
        Transport transport = session.getTransport();//根据session获取邮件传输对象

        transport.connect(sendEmail.getSendEamilAdrerss(),sendEmail.getSendEmailPassword());
        //发送邮件 ，发送到所有的邮件地址
        transport.sendMessage(message,message.getAllRecipients());
        //关闭连接
        transport.close();
    }

    /**
     * 创建一封邮件
     * @param session
     * @param sendEmail
     * @throws Exception
     */
    public static MimeMessage createMessage(Session session,SendEmail sendEmail)throws Exception{
        MimeMessage mimeMessage = new MimeMessage(session);//创建一封邮件
        //设置发件人邮箱和发件人昵称
        mimeMessage.setFrom(new InternetAddress(sendEmail.getSendEamilAdrerss(),sendEmail.getSendEmailName(),"UTF-8"));
        //设置收件人
       if(sendEmail.getReceiveEmailList()!=null&&sendEmail.getReceiveEmailList().size()>0){
           InternetAddress [] sendTo = new InternetAddress[sendEmail.getReceiveEmailList().size()];//创建一个收件人数组
           for (int i = 0; i <sendEmail.getReceiveEmailList().size() ; i++) {
            sendTo[i] = new InternetAddress(sendEmail.getReceiveEmailList().get(i).getReceiveEmailAccount(),
                    sendEmail.getReceiveEmailList().get(i).getReceiveEamilName(),"UTF-8");
           }
           mimeMessage.setRecipients(MimeMessage.RecipientType.TO,sendTo);
       }else{
           System.out.println("收件人不能为空！");
       }
       //4.邮件主题
        mimeMessage.setSubject(sendEmail.getSendEamilText(),"UTF-8");
       //5. Content: 邮件正文（可以使用html标签）
        mimeMessage.setContent(sendEmail.getSendEmailTheme(),"text/html;charset=UTF-8");
        //6.设置邮件发送时间
        mimeMessage.setSentDate(new Date());
       //7。保存设置
        mimeMessage.saveChanges();
        return mimeMessage;
    }

    /**
     * 测试邮件163邮箱到QQ邮箱
     * @throws Exception
     */
    public static void sendEamilToQQ()throws  Exception{
        SendEmail sendEmail =new SendEmail();
        sendEmail.setSendEmailSMTPHost("smtp.163.com");
        sendEmail.setSendEamilAdrerss("hkdyantianpeng@163.com");
        sendEmail.setSendEmailPassword("yantianpeng1014");
        sendEmail.setSendEmailName("yantianpeng");
        sendEmail.setSendEmailTheme("测试邮件");
        sendEmail.setSendEamilText("喊我大哥就可以了");
        //收件人信息
        List<ReceiveEmail> receiveEmailList =new ArrayList<>();
        ReceiveEmail receiveEmail01 = new ReceiveEmail();
        receiveEmail01.setReceiveEamilName("pengxiang");
        receiveEmail01.setReceiveEmailAccount("1113705474@qq.com");

        ReceiveEmail receiveEmail02 = new ReceiveEmail();
        receiveEmail02.setReceiveEamilName("闫天鹏");
        receiveEmail02.setReceiveEmailAccount("2593223743@qq.com");

        ReceiveEmail receiveEmail03 = new ReceiveEmail();
        receiveEmail03.setReceiveEamilName("蒋海峰");
        receiveEmail03.setReceiveEmailAccount("931009398@qq.com");

        ReceiveEmail receiveEmail05 = new ReceiveEmail();
        receiveEmail05.setReceiveEamilName("吴彦祖");
        receiveEmail05.setReceiveEmailAccount("942799629@qq.com");

        ReceiveEmail receiveEmail06 = new ReceiveEmail();
        receiveEmail06.setReceiveEamilName("廖赞");
        receiveEmail06.setReceiveEmailAccount("1355338624@qq.com");

        receiveEmailList.add(receiveEmail06);
        receiveEmailList.add(receiveEmail05);
        receiveEmailList.add(receiveEmail03);
        receiveEmailList.add(receiveEmail01);
        receiveEmailList.add(receiveEmail02);
        sendEmail.setReceiveEmailList(receiveEmailList);
        sendEmail(sendEmail);
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i <10 ; i++) {
            sendEamilToQQ();
            Thread.sleep(1000);
        }
    }
}
