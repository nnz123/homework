package com.ccbtrust.serviceperson.dao;

import com.ccbtrust.remoteclient.model.PersonUpdateDTO;

/**
 * 更新员工信息
 * @author nzhang
 */
public interface PersonUpdateDao {
    /**
     * 上传员工头像
     * @param id 员工id
     * @param localPictureAddr 员工头像存储地址
     * @return
     */
    int uploadPicture(int id, String localPictureAddr);

    /**
     * 更新员工基本信息
     * @param personUpdateDTO  员工基本信息DTO
     * @return
     */
    int updatePersonInfo(PersonUpdateDTO personUpdateDTO);

}
