package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.serviceperson.service.PersonUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 更新员工信息
 * @author nzhang
 */
@RestController
public class PersonUpdateController {

    @Autowired
    private PersonUpdateService personUpdateService;

    @RequestMapping(value = "/update/uploadPicture/{id}",method = RequestMethod.PUT)
    public void updatePicture(@PathVariable("id") int id, String localPictureAddr){
        personUpdateService.uploadPicture(id,localPictureAddr);
    }
}
