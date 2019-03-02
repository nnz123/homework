package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonUpdateService;
import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.remoteclient.util.ImageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改员工
 * @author nzhang
 */
@RestController
public class PersonUpdateController {
    @Autowired
    private PersonUpdateService personUpdateService;
    @ApiOperation("修改员工头像")
    @RequestMapping(value = "/person/update/uploadPicture/{id}", method = RequestMethod.PUT)
    public Map<String, Object> uploadPicture(@ApiParam("员工id") @PathVariable("id")int id, @ApiParam("员工的头像")@RequestParam("mPicture") MultipartFile mPicture) {
        Map<String, Object> map = new HashMap<>(16);
        String imageName = mPicture.getOriginalFilename();
        String localPictureAddr = ImageUtil.generateImageAddr(imageName);
        File file = new File(localPictureAddr);
        try {
            mPicture.transferTo(file);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "照片存储失败");
            return map;
        }

        try {
            personUpdateService.uploadPicture(id,localPictureAddr);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("message", "图片上传成功");
        return map;
    }


    @ApiOperation("修改员工基本信息")
    @RequestMapping(value = "/person/update/updatePersonInfo/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updatePersonInfo(@ApiParam("员工id")@PathVariable(value = "id") Integer id,@ApiParam("员工的姓名")@RequestParam(value = "personName",required = false) String personName,@ApiParam("员工的证件类型")@RequestParam(value = "cardType",required = false) Integer cardType,@ApiParam("员工的证件号码") @RequestParam(value = "cardNum",required = false) String cardNum,@ApiParam("员工的电话号码")@RequestParam(value = "phoneNum",required = false) String phoneNum ){
        Map<String, Object> map = new HashMap<>(16);
        PersonUpdateDTO  personUpdateDTO = new PersonUpdateDTO();
        personUpdateDTO.setId(id);
        personUpdateDTO.setPersonName(personName);
        personUpdateDTO.setCardType(cardType);
        personUpdateDTO.setCardNum(cardNum);
        personUpdateDTO.setPhoneNum(phoneNum);
        personUpdateDTO.setEditPerson("Jack");

        try {
            personUpdateService.updatePersonInfo(personUpdateDTO);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message",e.getMessage() );
            return map;
        }
        map.put("success", true);
        map.put("message", "员工基本信息修改完成");
        return map;
    }

}