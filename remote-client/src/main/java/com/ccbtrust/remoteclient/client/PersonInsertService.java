package com.ccbtrust.remoteclient.client;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * 添加员工
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonInsertService {

    /**
     * 增加员工
     * @param personInsertDTO 添加的员工信息DTO
     */
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    void insert(@RequestBody PersonInsertDTO personInsertDTO);




}
