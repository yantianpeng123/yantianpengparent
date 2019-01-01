package com.yantianpeng.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**

* @Description:

* @Author:        yantianpeng

* @CreateDate:     2018/12/27 下午2:27


*/
@Configuration
public class QueueConfig {
    @Value("${queue}")
    private String queue;


    @Bean
    public Queue loginQueue(){
        return new ActiveMQQueue(queue);
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory,Queue queue){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDeliveryMode(2);//1表示非持久化 ，2表示持久化
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(queue);//设置队列
        jmsTemplate.setSessionAcknowledgeMode(4);//4表示客户端签收
        return jmsTemplate;
    }

    @Bean(name = "jmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ActiveMQConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        //设置连接
        factory.setConcurrency("1-10");
        //重置间隔时间r
        factory.setRecoveryInterval(1000l);
        factory.setSessionAcknowledgeMode(4);
        return factory;

    }
}
