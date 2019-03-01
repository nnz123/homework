package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.serviceperson.service.PersonLeaveService;
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
public class PersonLeaveController {
    @Autowired
    private PersonLeaveService personLeaveService;

    @RequestMapping(value = "/leave/{id}",method = RequestMethod.PUT)
    public void leave(@PathVariable("id") int id, String editPerson){
        personLeaveService.leave(id,editPerson);
    }

}
