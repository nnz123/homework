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

    /**
     * 上传员工头像
     * @param id 员工id
     * @param localPictureAddr 头像存储地址
     */
    @RequestMapping(value = "/uploadPicture/{id}",method = RequestMethod.PUT)
    public void updatePicture(@PathVariable("id") Integer id, String localPictureAddr){
        personUpdateService.uploadPicture(id,localPictureAddr);
    }

    /**
     * 修改员工基本信息
     * @param personUpdateDTO 员工基本信息DTO
     */
    @RequestMapping(value = "/updatePersonInfo", method = RequestMethod.PUT)
    public void updatePersonInfo(@RequestBody PersonUpdateDTO personUpdateDTO){
        personUpdateService.updatePersonInfo(personUpdateDTO);
    }


}
