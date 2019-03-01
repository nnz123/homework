package com.ccbtrust.remoteclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

}
