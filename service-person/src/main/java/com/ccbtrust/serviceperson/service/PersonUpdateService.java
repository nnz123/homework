package com.ccbtrust.serviceperson.service;

import com.ccbtrust.remoteclient.model.PersonUpdateDTO;

/**
 * 跟新员工信息
 * @author nzhang
 */
public interface PersonUpdateService {
    /**
     * 上传员工头像
     * @param id 员工id
     * @param localPictureAddr  员工头像保存地址
     */
    void uploadPicture(int id,String localPictureAddr);

    /**
     * 更新员工信息
     * @param personUpdateDTO 更新员工信息DTO
     */
    void updatePersonInfo(PersonUpdateDTO personUpdateDTO);
}
