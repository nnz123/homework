package com.ccbtrust.remoteclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 员工离职
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonLeaveService {

    /**
     * y员工离职
     * @param id 员工id
     * @param editPerson 编辑人姓名
     */
    @RequestMapping(value = "/leave/{id}",method = RequestMethod.PUT)
    void leave(@PathVariable("id") int id, @RequestParam("editPerson") String editPerson);
}
