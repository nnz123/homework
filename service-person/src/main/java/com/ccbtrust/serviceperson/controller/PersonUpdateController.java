package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.serviceperson.service.PersonUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/update/updatePersonInfo", method = RequestMethod.PUT)
    public void updatePersonInfo(@RequestBody PersonUpdateDTO personUpdateDTO){
        personUpdateService.updatePersonInfo(personUpdateDTO);
    }


}
