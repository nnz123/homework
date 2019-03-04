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
 * 修改员工信息
 * @author nzhang
 */
@RestController
@RequestMapping("/person/update")
public class PersonUpdateController {
    @Autowired
    private PersonUpdateService personUpdateService;

    /**
     * 修改员工头像
     * @param id 员工id
     * @param mPicture 员工头像
     * @return  返回操作是否成功等信息
     */
    @ApiOperation("修改员工头像")
    @RequestMapping(value = "/uploadPicture/{id}", method = RequestMethod.PUT)
    public Map<String, Object> uploadPicture(@ApiParam("员工id") @PathVariable("id")int id, @ApiParam(value = "员工的头像",required = true)@RequestParam(value = "mPicture") MultipartFile mPicture) {
        //用于携带返回信息
        Map<String, Object> map = new HashMap<>(16);
        //判断头像是否上传
        if (mPicture==null){
            map.put("success", false);
            map.put("message", "必须选择头像");
            return map;
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
            map.put("success", false);
            map.put("message", e.getMessage());
            return map;
        }
        //将图片存储地址保存到数据库
        try {
            personUpdateService.uploadPicture(id,localPictureAddr);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("message", "头像上传成功！");
        return map;
    }

    /**
     * 修改员工基本信息
     * @param id 员工id
     * @param personName 员工姓名
     * @param cardType  员工证件类型
     * @param cardNum   员工证件号码
     * @param phoneNum  员工电话号码
     * @return   返回操作是否成功等信息
     */
    @ApiOperation("修改员工基本信息")
    @RequestMapping(value = "/updatePersonInfo/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updatePersonInfo(@ApiParam("员工id")@PathVariable(value = "id") Integer id,@ApiParam("员工的姓名")@RequestParam(value = "personName",required = false) String personName,@ApiParam("员工的证件类型")@RequestParam(value = "cardType",required = false) Integer cardType,@ApiParam("员工的证件号码") @RequestParam(value = "cardNum",required = false) String cardNum,@ApiParam("员工的电话号码")@RequestParam(value = "phoneNum",required = false) String phoneNum ){
        //用于携带返回信息
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