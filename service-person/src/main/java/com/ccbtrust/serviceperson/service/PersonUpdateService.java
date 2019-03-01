package com.ccbtrust.serviceperson.service;

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
}
