package com.usdj.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author gerrydeng
 * @date 2019-07-17 20:11
 * @Description:
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Resource(name = "activeMQTopic")
    private Destination destination;

    @Override
    public void sendMessage(String message) {
        jmsTemplate.send(destination, session -> session.createTextMessage(message));
    }
}
