package com.usdj.jms.config;

import com.usdj.jms.consumer.ConsumerMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import java.security.PrivateKey;

/**
 * @author gerrydeng
 * @date 2019-07-18 10:31
 * @Description:
 */
@Configuration
@ComponentScan("com.usdj.jms.producer")
public class ProducerConfiguration {

    private static final String brokerURL = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerURL);
        return activeMQConnectionFactory;
    }

    @Bean
    public SingleConnectionFactory singleConnectionFactory() {
        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
        singleConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
        return singleConnectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("my_queue");
    }

    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic("my_topic");
    }


    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(singleConnectionFactory());
        return jmsTemplate;
    }


}
