package com.ccbtrust.rabbitmqreceiver.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nzhang
 */
@Configuration
public class ReceiverConf {

    @Bean
    public Queue queue(){
        return new Queue("leave");
    }

}
