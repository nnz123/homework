package com.ccbtrust.serviceperson.dao;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;

import java.io.InputStream;


/**
 * @author nzhang
 */
public interface PersonInsertDao {
    /**
     * 增加员工
     * @param  personInsert 员工信息
     * @param image  员工头像流
     * @param  imageName  员工头像名称
     * @return 反回插入的行数
     *
     */
    int insert(PersonInsertDTO personInsertDTO);

    /**
     * 通过id删除员工
     * @param id 员工id
     * @return  返回删除的行数
     */
    int deleteById(int id);

    /**
     * 更新员工头像存储路径
     * @param personInsertDTO 员工头像存储路径
     * @return
     *
     */
    int updatePersonPicture(PersonInsertDTO personInsertDTO);

}
