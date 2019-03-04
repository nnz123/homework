package com.ccbtrust.apiperson.controller;

import com.ccbtrust.apiperson.model.PersonSelectConditionsVO;
import com.ccbtrust.apiperson.model.PersonSelectResultVO;
import com.ccbtrust.remoteclient.client.PersonSelectService;
import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
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
 * @author nzhang
 */
@RestController
@RequestMapping("/person/select")
public class PersonSelectController {
    @Autowired
    private PersonSelectService personSelectService;

    /**
     * 通过id查询员工
     * @param id 员工id
     * @return  查询到的信息
     */
    @ApiOperation("通过id查询员工")
    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
    public Map<String,Object> selectById(@ApiParam("员工id") @PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>(16);
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO = personSelectService.selectById(id);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
        //将DTO转换为VO
        selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
        map.put("success",true);
        map.put("message","查询成功");
        map.put("person",personSelectResultVO);
        return map;
    }


    /**
     * 通过证件号码查询员工
     * @param cardNum 证件号码
     * @return  查询到的信息
     */
    @ApiOperation("根据证件号码查询员工")
    @RequestMapping(value = "/selectByCardNum/{cardNum}",method = RequestMethod.GET)
    public Map<String,Object> selectByCardNum(@ApiParam("证件号码")@PathVariable("cardNum") String cardNum){
        Map<String,Object> map = new HashMap<>(16);
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO = personSelectService.selectByCardNum(cardNum);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
        //将DTO转换为VO
        selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
        map.put("success",true);
        map.put("message","查询成功");
        map.put("person",personSelectResultVO);
        return map;
    }

    /**
     *  分页查询所有员工信息
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 查询到的信息
     */
    @ApiOperation("查询所有员工信息")
    @RequestMapping(value = "/selectAll/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Map<String,Object> selectAll(@ApiParam("页码")@PathVariable("pageNum") int pageNum,@ApiParam("每页显示条数") @PathVariable("pageSize") int pageSize){
        Map<String,Object> map = new HashMap<>(16);
        List<PersonSelectResultDTO> personSelectResultDTOList;
        try {
            if (pageNum<1||pageSize<1){
                map.put("success",false);
                map.put("message","请输入正确的页码和每页显示的条数");
                return map;
            }
                personSelectResultDTOList = personSelectService.selectAll(pageNum, pageSize);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;

        }
        List<PersonSelectResultVO> personSelectResultVOList = new ArrayList<>();
        for (PersonSelectResultDTO personSelectResultDTO : personSelectResultDTOList) {
            PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
            selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
            personSelectResultVOList.add(personSelectResultVO);
        }
        map.put("success",true);
        map.put("message","查询成功");
        map.put("persons",personSelectResultVOList);
        return map;
    }

    /**
     * 通过组合条件查询, 姓名为XX， 证件类型XX的，创建日期在yyyy-MM-dd HH:mm:ss之后的
     * @param personSelectConditionsVO 查询条件
     * @return 返回查询结果
     */
    @ApiOperation("通过组合条件查询员工")
    @RequestMapping(value = "/selectByConditions",method = RequestMethod.POST)
    Map<String, Object> selectByConditions(@ApiParam("查询条件VO")@Valid PersonSelectConditionsVO personSelectConditionsVO){
        Map<String,Object> map = new HashMap<>(16);
        PersonSelectConditionsDTO personSelectConditionsDTO = new PersonSelectConditionsDTO();
        if (personSelectConditionsVO!=null){
            personSelectConditionsDTO.setPersonName(personSelectConditionsVO.getPersonName());
            personSelectConditionsDTO.setCardType(personSelectConditionsVO.getCardType());
            personSelectConditionsDTO.setCreatePerson(personSelectConditionsVO.getCreatePerson());
            personSelectConditionsDTO.setCreateTime(personSelectConditionsVO.getCreateTime());
            personSelectConditionsDTO.setPageNum(personSelectConditionsVO.getPageNum());
            personSelectConditionsDTO.setPageSize(personSelectConditionsVO.getPageSize());
        }
        List<PersonSelectResultDTO> personSelectResultDTOList;
        try {
            personSelectResultDTOList = personSelectService.selectByConditions(personSelectConditionsDTO);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }

        List<PersonSelectResultVO> personSelectResultVOList = new ArrayList<>();
        for (PersonSelectResultDTO personSelectResultDTO : personSelectResultDTOList) {
            PersonSelectResultVO personSelectResultVO = new PersonSelectResultVO();
            selectResultDTOToVo(personSelectResultDTO, personSelectResultVO);
            personSelectResultVOList.add(personSelectResultVO);
        }
        map.put("success",true);
        map.put("message","查询成功");
        map.put("persons",personSelectResultVOList);
        return map;

    }

    /**
     * 将查询结果由DTO转换为VO
     * @param personSelectResultDTO  查询结果DTO
     * @param personSelectResultVO   查询结果VO
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
