package com.ccbtrust.apiperson.controller;

import com.ccbtrust.apiperson.model.PersonInsertVO;
import com.ccbtrust.remoteclient.client.PersonInsertService;
import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.remoteclient.model.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


/**
 * 添加员工
 *
 * @author nzhang
 */
@RestController
@RequestMapping("/person")
public class PersonInsertController {

    @Autowired
    private PersonInsertService personInsertService;

    @ApiOperation("添加员工")
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public Result insert(@Valid @RequestBody PersonInsertVO personInsertVO) {
        PersonInsertDTO personInsertDTO = new PersonInsertDTO();
        //personInsertVO转换为DTO
        personInsertDTO.setPersonName(personInsertVO.getPersonName());
        personInsertDTO.setCardType(personInsertVO.getCardType());
        personInsertDTO.setCardNum(personInsertVO.getCardNum());
        personInsertDTO.setPhoneNum(personInsertVO.getPhoneNum());
        //设定头像的存储路径
        personInsertDTO.setPersonPicture("D:\\ideaWorkspace\\image\\default.JPG");
        //设定默认创建人
        personInsertDTO.setCreatePerson("Nancy");

        try {
            personInsertService.insert(personInsertDTO);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
        return new Result<>(true, null, "员工添加成功！");
    }

}
