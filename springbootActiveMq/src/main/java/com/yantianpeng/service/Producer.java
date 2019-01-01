package com.yantianpeng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**

* @Description:    生产者

* @Author:        yantianpeng

* @CreateDate:     2018/12/27 下午2:40


*/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired(required = true)
    private Queue queue;

    /**
     * 生产者
     */
    @Scheduled(fixedDelay = 3000)
    public void sendMsg(){
        jmsMessagingTemplate.convertAndSend(queue,System.currentTimeMillis()+"----");
    }

    /**
     * 消费者
     * @param
     */
    @JmsListener(destination = "${queue}")
    public void reccive(TextMessage  msg, Session session)throws Exception{
        String jmsMessageID = msg.getJMSMessageID();//使用全局Id解决幂等性问题。可以解决重复消费的问题
        String text = msg.getText();
        System.out.println("消费者信息"+text);
        int i =1/0;
        msg.acknowledge();
    }

    public static void main(String[] args) {
        SpringApplication.run(Producer.class,args);
    }
}
