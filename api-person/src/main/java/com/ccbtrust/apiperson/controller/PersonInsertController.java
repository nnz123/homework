package com.ccbtrust.apiperson.controller;

import com.ccbtrust.apiperson.model.PersonInsertVO;
import com.ccbtrust.remoteclient.client.PersonInsertService;
import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.remoteclient.model.Result;
import com.ccbtrust.remoteclient.util.ImageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nzhang
 */
@RestController
@RequestMapping("/person/insert")
public class PersonInsertController {

    @Autowired
    private PersonInsertService personInsertService;

    /**
     * 添加员工共信息并上传图片 参数为request
     * @param personInsertVO  插入员工的VO
     * @return 返回操作是否成功等信息
     */
    @ApiOperation("添加员工信息")
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public Result insert(@ApiParam("员工基本信息personName,cardType, cardNum,phoneNum")@Valid PersonInsertVO personInsertVO) {
        PersonInsertDTO personInsertDTO = new PersonInsertDTO();
        //添加用户基础信息
        if (personInsertVO != null) {
            personInsertDTO.setPersonName(personInsertVO.getPersonName());
            personInsertDTO.setCardType(personInsertVO.getCardType());
            personInsertDTO.setCardNum(personInsertVO.getCardNum());
            personInsertDTO.setPhoneNum(personInsertVO.getPhoneNum());
            personInsertDTO.setPersonPicture("D:\\ideaWorkspace\\image\\default.JPG");
            personInsertDTO.setCreatePerson("Nancy");
            try {
                personInsertService.insert(personInsertDTO);
            } catch (Exception e) {
                return new Result(false,e.getMessage());
            }
        }
        return new Result<>(true,null,"员工添加成功！");
    }

}
