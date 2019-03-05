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

    /**
     * 根据id删除员工
     * @param id 员工id
     * @param deletePerson 删除操作者姓名
     */
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.PUT)
    public void deleteById(@PathVariable("id") Integer id,String deletePerson){
        personDeleteService.deleteById(id,deletePerson);
    }
}
