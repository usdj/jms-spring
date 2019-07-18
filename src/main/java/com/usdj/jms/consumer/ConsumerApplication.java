package com.usdj.jms.consumer;

import com.usdj.jms.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gerrydeng
 * @date 2019-07-17 21:09
 * @Description:
 */
public class ConsumerApplication {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
    }
}
