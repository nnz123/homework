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
     * @return 反回修改的条数
     */
    int uploadPicture(Integer id, String localPictureAddr);

    /**
     * 修改员工基本信息
     * @param personUpdateDTO  员工基本信息DTO
     * @return 返回修改的条数
     */
    int updatePersonInfo(PersonUpdateDTO personUpdateDTO);

}
