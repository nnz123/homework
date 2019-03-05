package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonDeleteService;
import com.ccbtrust.remoteclient.model.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 删除员工
 * @author nzhang
 */
@RestController
@RequestMapping("/person")
public class PersonDeleteController {

    @Autowired
    private PersonDeleteService personDeleteService;

    @ApiOperation("根据id删除员工信息")
    @RequestMapping(value = "deleteById/{id}",method = RequestMethod.PUT)
    public Result deleteById(@ApiParam(value = "员工id",required = true) @PathVariable("id")Integer id) {
        //设定默认的删除操作者姓名
        String deletePerson = "Tom";
        try {
            personDeleteService.deleteById(id,deletePerson);
        }catch (Exception e){
            return new Result(false,e.getMessage());
        }
        return new Result<>(true,null,id+"号员工删除成功！");
    }
}
