package com.usdj.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gerrydeng
 * @date 2019-07-17 21:09
 * @Description:
 */
public class ConsumerApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
