package com.ccbtrust.apiperson.controller;

import com.ccbtrust.remoteclient.client.PersonUpdateService;
import com.ccbtrust.remoteclient.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改员工
 * @author nzhang
 */
@RestController
public class PersonUpdateController {
    @Autowired
    private PersonUpdateService personUpdateService;

    @RequestMapping(value = "/person/update/uploadPicture/{id}", method = RequestMethod.PUT)
    public Map<String, Object> uploadPicture(@PathVariable("id") int id, @RequestParam("mPicture") MultipartFile mPicture) {
        Map<String, Object> map = new HashMap<>(16);
        String imageName = mPicture.getOriginalFilename();
        String localPictureAddr = ImageUtil.generateImageAddr(imageName);
        File file = new File(localPictureAddr);
        try {
            mPicture.transferTo(file);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "照片存储失败");
            return map;
        }

        try {
            personUpdateService.uploadPicture(id,localPictureAddr);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("message", "图片上传成功");
        return map;
    }
}