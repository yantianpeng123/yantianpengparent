package com.yantianpeng.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**

* @Description:    点对点模式activemq生产者

* @Author:        yantianpeng

* @CreateDate:     2018/12/26 下午2:37


*/
public class Producer {

//    public static void main(String[] args) throws Exception{
//       // producerTest();
//    }
    public static void producerTest(String string)throws Exception{
        //账号
         String user = ActiveMQConnection.DEFAULT_USER;
         //密码
         String password= ActiveMQConnection.DEFAULT_PASSWORD;
         //连接
         String brokerURL="tcp://127.0.0.1:61616";
         //创建连接工厂
        ConnectionFactory connectionFactory =new ActiveMQConnectionFactory(user,password,brokerURL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建队列'
        Destination destination = session.createQueue("testQueue");
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        //不保存到本地
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        sendMsg(session,producer,string);
    }

    public static void  sendMsg(Session session ,MessageProducer messageProducerm,String string)throws Exception{
        TextMessage textMessage = session.createTextMessage(string);
        messageProducerm.send(textMessage);
    }
}
