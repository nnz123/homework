package com.ccbtrust.serviceperson.controller;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.serviceperson.service.PersonInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nzhang
 */
@RestController
public class PersonInsertController {
    @Autowired
    private PersonInsertService personService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insert(@RequestBody PersonInsertDTO personInsertDTO){
        personService.insert(personInsertDTO);
    }

    @RequestMapping(value = "/delete/{id}",method =RequestMethod.GET)
    public void deleteById(@PathVariable("id") int id){
        personService.deleteById(id);
    }
}
