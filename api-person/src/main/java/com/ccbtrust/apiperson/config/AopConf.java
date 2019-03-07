package com.ccbtrust.apiperson.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/**
 * aop 发送rabbit信息
 * @author nzhang
 */
@Aspect
@Configuration
public class AopConf {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @AfterReturning("execution(* com.ccbtrust.remoteclient.client.PersonLeaveService.leave(Integer,String))")
    public void afterLeave(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        amqpTemplate.convertAndSend("leave","id为"+args[0]+"的员工离职");
    }
}
