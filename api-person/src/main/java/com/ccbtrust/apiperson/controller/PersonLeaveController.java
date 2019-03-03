package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonLeaveService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工离职
 * @author nzhang
 */
@RestController
public class PersonLeaveController {
    @Autowired
    private PersonLeaveService personLeaveService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ApiOperation("员工离职")
    @RequestMapping(value = "/person/leave/{id}",method = RequestMethod.PUT)
    public Map<String,Object> leave(@ApiParam("员工id") @PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>(16);
        String editPerson = "Jack";
        try {
            personLeaveService.leave(id,editPerson);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        amqpTemplate.convertAndSend("leave","员工id:"+id+"离职");
        map.put("success",true);
        map.put("message",id+"号员工离职成功");
        return map;
    }



}
