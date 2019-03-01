package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonLeaveService;
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

    @RequestMapping(value = "/person/leave/{id}",method = RequestMethod.PUT)
    public Map<String,Object> leave(@PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>(16);
        String editPerson = "Jack";
        try {
            personLeaveService.leave(id,editPerson);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        map.put("success",true);
        map.put("message",id+"号员工离职成功");
        return map;
    }



}
