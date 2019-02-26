package com.ccbtrust.remoteclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonClient {

    /**
     * 增加员工
     * @param personInsert 增加的用户信息
     */

    //void insert(PersonInsert personInsert);

    /**
     * 通过id删除员工信息
     * @param id 员工id
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    void deleteById(@PathVariable("id") int id);


}
