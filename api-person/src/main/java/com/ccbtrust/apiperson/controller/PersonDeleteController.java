package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除员工
 * @author nzhang
 */
@RestController
public class PersonDeleteController {

    @Autowired
    private PersonDeleteService personDeleteService;
    /**
     * 根据id 删除信息
     *
     * @param id 员工id
     */
    @RequestMapping(value = "/person/delete/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteById(@PathVariable("id") int id) {
        Map<String,Object> map = new HashMap<>();
        try {
            personDeleteService.deleteById(id);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        map.put("success",true);
        map.put("message","删除成功");
        return map;
    }
}
