package com.ccbtrust.serviceperson.dao;

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
}
