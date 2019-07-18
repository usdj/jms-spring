package com.usdj.jms.config;

import com.usdj.jms.consumer.ConsumerMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * @author gerrydeng
 * @date 2019-07-18 14:11
 * @Description:
 */
@Configuration
public class ConsumerConfiguration {

    private static final String brokerURL = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
    private static final ConsumerMessageListener consumerMessageListener = new ConsumerMessageListener();

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
    public DefaultMessageListenerContainer defaultMessageListenerContainer() {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(singleConnectionFactory());
        // 使用队列设置为activeMQQueue，使用话题则设置activeMQTopic
        defaultMessageListenerContainer.setDestination(activeMQTopic());
        defaultMessageListenerContainer.setMessageListener(consumerMessageListener);
        return defaultMessageListenerContainer;
    }
}
