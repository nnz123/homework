package com.ccbtrust.serviceperson.controller;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.serviceperson.service.PersonInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 添加员工
 * @author nzhang
 */
@RestController
public class PersonInsertController {
    @Autowired
    private PersonInsertService personInsertService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insert(@RequestBody PersonInsertDTO personInsertDTO){
        personInsertService.insert(personInsertDTO);
    }


}
