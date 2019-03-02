package com.ccbtrust.remoteclient.client;

import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 员工信息修改
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonUpdateService {
    /**
     * 上传头像
     * @param id 用户id
     * @param localPictureAddr 用户头像存储地址
     */
    @RequestMapping(value = "/update/uploadPicture/{id}",method = RequestMethod.PUT)
    void uploadPicture(@PathVariable("id") int id, @RequestParam("localPictureAddr") String localPictureAddr);

    /**
     * 修改员工基本信息
     * @param personUpdateDTO 员工基本信息DTO
     */
    @RequestMapping(value = "/update/updatePersonInfo", method = RequestMethod.PUT)
    void updatePersonInfo(@RequestBody PersonUpdateDTO personUpdateDTO);
}
