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

    /**
     * 添加员工信息
     * @param personInsertDTO 员工信息DTO
     */
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public void insert(@RequestBody PersonInsertDTO personInsertDTO){
        personInsertService.addPerson(personInsertDTO);
    }
}
