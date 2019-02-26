package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nzhang
 */
@RestController
public class PersonController {

    @Autowired
    private PersonClient personClient;

    @RequestMapping(value = "/person/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        personClient.deleteById(id);

    }





}
