package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonLeaveService;
import com.ccbtrust.remoteclient.model.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 员工离职
 * @author nzhang
 */
@RestController
@RequestMapping("/person")
public class PersonLeaveController {
    @Autowired
    private PersonLeaveService personLeaveService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ApiOperation("员工离职")
    @RequestMapping(value = "/leave/{id}",method = RequestMethod.PUT)
    public Result leave(@ApiParam(value = "员工id",required = true) @PathVariable("id") Integer id){
        //设置默认的操作人姓名
        String editPerson = "Jack";
        try {
            personLeaveService.leave(id,editPerson);
        } catch (Exception e) {
            return new Result(false,e.getMessage());
        }
        //向第三方发送离职消息
        amqpTemplate.convertAndSend("leave","员工id:"+id+"离职");
        return new Result<>(true,null,id+"号员工离职成功！");
    }

}
