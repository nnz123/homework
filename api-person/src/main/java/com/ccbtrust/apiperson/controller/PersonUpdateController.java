package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonUpdateService;
import com.ccbtrust.remoteclient.enums.PersonCardType;
import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.remoteclient.model.Result;
import com.ccbtrust.remoteclient.util.ImageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

/**
 * 修改员工信息
 * @author nzhang
 */
@RestController
@RequestMapping("/person")
public class PersonUpdateController {
    @Autowired
    private PersonUpdateService personUpdateService;

    @ApiOperation("修改员工头像")
    @RequestMapping(value = "/uploadPicture/{id}", method = RequestMethod.PUT)
    public Result uploadPicture(@ApiParam(value = "员工id",required = true) @PathVariable("id") Integer id, @ApiParam(value = "员工的头像", required = true) @RequestParam(value = "mPicture") MultipartFile mPicture) {
        //判断头像是否上传
        if (mPicture == null) {
            return new Result<>(false, "必须上传头像");
        }
        //获取头像名称
        String imageName = mPicture.getOriginalFilename();
        //获取头像的全路径
        String localPictureAddr = ImageUtil.generateImageAddr(imageName);
        //将头像存储在本地
        File file = new File(localPictureAddr);
        try {
            mPicture.transferTo(file);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
        //将图片存储地址保存到数据库
        try {
            personUpdateService.uploadPicture(id, localPictureAddr);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
        return new Result<>(true, null, id + "号员工头像上传成功！");
    }


    @ApiOperation("修改员工基本信息")
    @RequestMapping(value = "/updatePersonInfo/{id}", method = RequestMethod.PUT)
    public Result updatePersonInfo(@ApiParam(value = "员工id",required = true) @PathVariable(value = "id") Integer id, @ApiParam("员工的姓名") @RequestParam(value = "personName", required = false) String personName, @ApiParam("证件类型") @RequestParam(value = "cardType", required = false) PersonCardType cardType, @ApiParam("员工的证件号码") @RequestParam(value = "cardNum", required = false) String cardNum, @ApiParam("员工的电话号码") @RequestParam(value = "phoneNum", required = false) String phoneNum) {
        PersonUpdateDTO personUpdateDTO = new PersonUpdateDTO();
        //将参数封装进DTO
        personUpdateDTO.setId(id);
        //设定默认的修改人姓名
        personUpdateDTO.setEditPerson("Jack");
        if (personName != null) {
            String regexp = "([\u4e00-\u9fa5]|[a-z]|[A-Z]){2,20}$";
            if (!personName.matches(regexp)) {
                return new Result(false, "新名字不符合要求，名字需要是20个以内的汉字或英文字母组成");
            }
            personUpdateDTO.setPersonName(personName);
        }
        if (cardType != null) {
            personUpdateDTO.setCardType(cardType);
        }
        if (cardNum != null) {
            personUpdateDTO.setCardNum(cardNum);
        }
        if (phoneNum != null) {
            String regexp2 = "^1[3-8][0-9]{9}$";
            if (!phoneNum.matches(regexp2)) {
                return new Result(false, "电话号码格式不对");
            }
            personUpdateDTO.setPhoneNum(phoneNum);
        }
        try {
            personUpdateService.updatePersonInfo(personUpdateDTO);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
        return new Result<>(true, null, id + "号员工信息修改成功！");
    }

}