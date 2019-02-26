package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.serviceperson.entity.PersonInsert;
import com.ccbtrust.serviceperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nzhang
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insert(@RequestBody  PersonInsert personInsert){
        personService.insert(personInsert);
    }

    @RequestMapping(value = "/delete/{id}",method =RequestMethod.GET)
    public void deleteById(@PathVariable("id") int id){
        personService.deleteById(id);
    }
}
