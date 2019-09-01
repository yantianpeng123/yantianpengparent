package com.yantianpeng.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/27 上午9:36


*/
public class ConsumerTopic {

//    public static void main(String[] args) throws Exception{
//        consumerTest();
//    }
    public static void consumerTest()throws Exception{
        //账号
        String user = ActiveMQConnection.DEFAULT_USER;
        //密码
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        //连接
        String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
        //创建工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerURL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Destination destination = session.createTopic("testTopic1");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true){
          //  TextMessage textMessage = session.createTextMessage();
            TextMessage textMessage = (TextMessage)consumer.receive();
            if(textMessage!=null){
                String text  =  textMessage.getText();
                System.out.println("消费者获取的队列信息：" +text);
                //手动签收
               // textMessage.acknowledge();
            }else{
                break;
            }
        }
        System.out.println("信息消费完毕！");

    }
}
