package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonDeleteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除员工
 * @author nzhang
 */
@RestController
public class PersonDeleteController {

    @Autowired
    private PersonDeleteService personDeleteService;
    /**
     * 根据id 删除信息
     *
     * @param id 员工id
     */
    @ApiOperation("根据id删除员工信息")
    @RequestMapping(value = "/person/delete/{id}",method = RequestMethod.PUT)
    public Map<String,Object> deleteById(@ApiParam("员工id") @PathVariable("id")int id) {
        Map<String,Object> map = new HashMap<>(16);
        String deletePerson = "Tom";
        try {
            personDeleteService.deleteById(id,deletePerson);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
        map.put("success",true);
        map.put("message",id +"号员工删除成功");
        return map;
    }
}
