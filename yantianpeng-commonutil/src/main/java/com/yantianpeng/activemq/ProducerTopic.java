package com.yantianpeng.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
  需要消费者先订阅，生产者生产的东西才可以
* @Description:    activemq 主题模式

* @Author:        yantianpeng

* @CreateDate:     2018/12/26 下午4:59


*/
public class ProducerTopic {

    public static void main(String[] args) throws Exception{
        ProducerTopic();
    }
    public static void ProducerTopic()throws Exception{
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String bordel =  ActiveMQConnection.DEFAULT_BROKER_URL;
        //创建工厂
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(user,password,bordel);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建主题
     //   Destination testTopic = session.createTopic("testTopic");
        //创建生产者
        MessageProducer producer = session.createProducer(null);
        //不做持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        for (int i = 0; i <100000000 ; i++) {
            sendMsg(session,producer,"我是主题模式："+i);
        }
    }

    public static void sendMsg(Session session,MessageProducer messageProducer,String string)throws  Exception{
        TextMessage textMessage = session.createTextMessage("hello qctvemq"+string);
        Destination destination = session.createTopic("testTopic1");
        messageProducer.send(destination,textMessage);
    }
}
