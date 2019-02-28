package com.ccbtrust.remoteclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 删除员工
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonDeleteService {

    /**
     * 通过id删除员工信息
     * @param id 员工id
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    void deleteById(@PathVariable("id") int id);
}
