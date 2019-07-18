package com.usdj.jms.producer;

/**
 * @author gerrydeng
 * @date 2019-07-17 20:03
 * @Description:
 */
public interface ProducerService {
    /**
     * Test send message method
     * @param message
     */
    void sendMessage(String message);
}
