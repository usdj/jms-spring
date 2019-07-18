package com.usdj.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author gerrydeng
 * @date 2019-07-17 21:04
 * @Description:
 */
public class ConsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("Received:" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
