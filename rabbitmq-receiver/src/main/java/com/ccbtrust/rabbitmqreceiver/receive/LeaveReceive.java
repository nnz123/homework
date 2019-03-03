package com.ccbtrust.rabbitmqreceiver.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nzhang
 */
@Component
public class LeaveReceive {

    @RabbitListener(queues="leave")
    public void receiveHello(String str){
        System.out.println("Receive:"+str);
    }
}
