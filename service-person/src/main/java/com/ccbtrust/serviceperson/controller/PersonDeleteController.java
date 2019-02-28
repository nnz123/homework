package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.serviceperson.service.PersonDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * 删除员工
 * @author nzhang
 */
@RestController
public class PersonDeleteController {
    @Autowired
    private PersonDeleteService personDeleteService;

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") int id){
        personDeleteService.deleteById(id);
    }
}
