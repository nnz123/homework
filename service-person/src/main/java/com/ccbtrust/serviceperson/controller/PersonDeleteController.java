package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.service.PersonDeleteService;
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

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") int id){
        personDeleteService.deleteById(id);
    }
}
