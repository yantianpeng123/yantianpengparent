package com.yantianpeng.activemq;

import com.yantianpeng.Chapter06.Print;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**

* @Description:   点对点模式  activeMq消费者代码

* @Author:        yantianpeng

* @CreateDate:     2018/12/26 下午3:43


*/
public class ConsumerTest {

    public static void main(String[] args) throws Exception{
        Consumer();
    }
    public static void Consumer()throws Exception{
        //账号         ActiveMQConnection.DEFAULT_USER
        String user = ActiveMQConnection.DEFAULT_USER;
        //密码
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        //连接
        String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
        //创建工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerURL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Destination testQueue = session.createQueue("testQueue");
        MessageConsumer consumer = session.createConsumer(testQueue);
        while (true){
            TextMessage receive = (TextMessage) consumer.receive();
            String text = receive.getText();
          Print.printString(text);
        }


    }
}
