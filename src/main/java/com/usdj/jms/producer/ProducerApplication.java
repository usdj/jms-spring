package com.usdj.jms.producer;

import com.usdj.jms.config.ProducerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author gerrydeng
 * @date 2019-07-17 20:18
 * @Description:
 */
public class ProducerApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerServiceImpl producerService = context.getBean(ProducerServiceImpl.class);
        for (int i = 0; i < 1000; i++) {
            producerService.sendMessage("Hello"+ i);

        }
        context.close();
    }
}
