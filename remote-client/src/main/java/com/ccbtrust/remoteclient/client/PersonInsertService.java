package com.ccbtrust.remoteclient.client;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonInsertService {

    /**
     * 增加员工
     * @param personInsertDTO 增加的用户信息
     * @return 返回插入的行数
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    void insert(@RequestBody PersonInsertDTO personInsertDTO);

    /**
     * 通过id删除员工信息
     * @param id 员工id
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    void deleteById(@PathVariable("id") int id);


}
