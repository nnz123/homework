package com.ccbtrust.apiperson.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author nzhang
 */
@Component
public class RabbitmqSenderConf {
    @Bean
    public Queue send(){
        return new Queue("leave");
    }

}
