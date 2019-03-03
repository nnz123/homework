package com.ccbtrust.serviceperson.controller;

import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import com.ccbtrust.serviceperson.service.PersonSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 查询员工
 * @author nzhang
 */
@RestController
public class PersonSelectController {
    @Autowired
    private PersonSelectService personSelectService;

    @RequestMapping(value = "/select/selectById/{id}",method = RequestMethod.GET)
    public PersonSelectResultDTO selectById(@PathVariable("id") int id){
        return personSelectService.selectById(id);
    }

    @RequestMapping(value = "/select/selectByCardNum/{cardNum}",method = RequestMethod.GET)
    public PersonSelectResultDTO selectByCardNum(@PathVariable("cardNum") String cardNum){
        return personSelectService.selectByCardNum(cardNum);
    }

    @RequestMapping(value = "/select/selectAll/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public List<PersonSelectResultDTO> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return personSelectService.selectAll(pageNum,pageSize);
    }

    /**
     * 通过组合条件查询
     * @param personSelectConditionsDTO 查询条件
     * @return 返回查询结果
     */
    @RequestMapping(value = "/select/selectByConditions",method = RequestMethod.POST)
    public List<PersonSelectResultDTO> selectByConditions(@RequestBody PersonSelectConditionsDTO personSelectConditionsDTO){
        return personSelectService.selectByConditions(personSelectConditionsDTO);
    }




}
