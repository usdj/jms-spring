package com.usdj.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gerrydeng
 * @date 2019-07-17 20:18
 * @Description:
 */
public class ProducerApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerServiceImpl producerService = context.getBean("producerService", ProducerServiceImpl.class);
        for (int i = 0; i < 10000; i++) {
            producerService.sendMessage("Hello"+ i);

        }
        context.close();
    }
}
