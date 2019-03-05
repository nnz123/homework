package com.ccbtrust.apiperson.controller;

import com.ccbtrust.apiperson.model.PersonSelectConditionsVO;
import com.ccbtrust.apiperson.model.PersonSelectResultVO;
import com.ccbtrust.remoteclient.client.PersonSelectService;
import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import com.ccbtrust.remoteclient.model.Result;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询员工
 *
 * @author nzhang
 */
@RestController
@RequestMapping("/person")
public class PersonSelectController {
    @Autowired
    private PersonSelectService personSelectService;

    @ApiOperation("通过id查询员工")
    @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
    public Result<PersonSelectResultVO> selectById(@ApiParam(value = "员工id",required = true) @PathVariable("id") Integer id) {
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO = personSelectService.selectById(id);
        } catch (Exception e) {
            return new Result<>(false, e.getMessage());
        }
        PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
        //将DTO转换为VO
        selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
        return new Result<>(true, personSelectResultVO, "查询成功！");
    }


    @ApiOperation("根据证件号码查询员工")
    @RequestMapping(value = "/selectByCardNum/{cardNum}", method = RequestMethod.GET)
    public Result<PersonSelectResultVO> selectByCardNum(@ApiParam(value = "证件号码",required = true) @PathVariable("cardNum") String cardNum) {
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO = personSelectService.selectByCardNum(cardNum);
        } catch (Exception e) {
            return new Result<>(false, e.getMessage());
        }
        PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
        //将DTO转换为VO
        selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
        return new Result<>(true, personSelectResultVO, "查询成功！");
    }


    @ApiOperation("查询所有员工信息")
    @RequestMapping(value = "/selectAll/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Result<List<PersonSelectResultVO>> selectAll(@ApiParam(value = "页码",required = true) @PathVariable("pageNum") Integer pageNum, @ApiParam(value = "每页显示条数",required = true) @PathVariable("pageSize") Integer pageSize) {
        List<PersonSelectResultDTO> personSelectResultDTOList;
        try {
            if (pageNum < 1 || pageSize < 1) {
                return new Result<>(false, "请输入正确的页码和每页显示的条数");
            }
            personSelectResultDTOList = personSelectService.selectAll(pageNum, pageSize);
        } catch (Exception e) {
            return new Result<>(false, e.getMessage());
        }
        List<PersonSelectResultVO> personSelectResultVOList = new ArrayList<>();
        for (PersonSelectResultDTO personSelectResultDTO : personSelectResultDTOList) {
            PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
            //DTO转化为VO
            selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
            personSelectResultVOList.add(personSelectResultVO);
        }
        return new Result<>(true, personSelectResultVOList, "查询成功！");
    }


    @ApiOperation("通过组合条件查询员工")
    @RequestMapping(value = "/selectByConditions/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public Result<List<PersonSelectResultVO>> selectByConditions(@RequestBody PersonSelectConditionsVO personSelectConditionsVO, @ApiParam(value = "页码",required = true) @PathVariable("pageNum") Integer pageNum, @ApiParam(value = "每页显示的信息数量",required = true) @PathVariable("pageSize") Integer pageSize) {
        PersonSelectConditionsDTO personSelectConditionsDTO = new PersonSelectConditionsDTO();
        //VO转换为DTO
        personSelectConditionsDTO.setPersonName(personSelectConditionsVO.getPersonName());
        personSelectConditionsDTO.setCardType(personSelectConditionsVO.getCardType());
        personSelectConditionsDTO.setCreatePerson(personSelectConditionsVO.getCreatePerson());
        personSelectConditionsDTO.setCreateTime(personSelectConditionsVO.getCreateTime());
        personSelectConditionsDTO.setEditPerson(personSelectConditionsVO.getEditPerson());
        personSelectConditionsDTO.setPersonStatus(personSelectConditionsVO.getPersonStatus());
        personSelectConditionsDTO.setPageNum(pageNum);
        personSelectConditionsDTO.setPageSize(pageSize);

        List<PersonSelectResultDTO> personSelectResultDTOList;
        try {
            personSelectResultDTOList = personSelectService.selectByConditions(personSelectConditionsDTO);
        } catch (Exception e) {
            return new Result<>(false, e.getMessage());
        }
        List<PersonSelectResultVO> personSelectResultVOList = new ArrayList<>();
        for (PersonSelectResultDTO personSelectResultDTO : personSelectResultDTOList) {
            PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
            selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
            personSelectResultVOList.add(personSelectResultVO);
        }
        return new Result<>(true, personSelectResultVOList, "查询成功！");
    }

    /**
     * 将查询结果由DTO转换为VO
     *
     * @param personSelectResultDTO 查询结果DTO
     * @param personSelectResultVO  查询结果VO
     */
    private void selectResultDTOToVo(PersonSelectResultDTO personSelectResultDTO, PersonSelectResultVO personSelectResultVO) {
        personSelectResultVO.setId(personSelectResultDTO.getId());
        personSelectResultVO.setPersonName(personSelectResultDTO.getPersonName());
        personSelectResultVO.setCardType(personSelectResultDTO.getCardType());
        personSelectResultVO.setCardNum(personSelectResultDTO.getCardNum());
        personSelectResultVO.setPhoneNum(personSelectResultDTO.getPhoneNum());
        personSelectResultVO.setPersonStatus(personSelectResultDTO.getPersonStatus());
        personSelectResultVO.setCreatePerson(personSelectResultDTO.getCreatePerson());
        personSelectResultVO.setCreateTime(personSelectResultDTO.getCreateTime());
    }
}
