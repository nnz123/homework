package com.ccbtrust.remoteclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 删除员工
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonDeleteService {

    /**
     * 通过id删除员工信息
     * @param id 员工id
     * @param deletePerson 删除操作者姓名
     */
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.PUT)
    void deleteById(@PathVariable("id")Integer id,@RequestParam("deletePerson") String deletePerson);
}
