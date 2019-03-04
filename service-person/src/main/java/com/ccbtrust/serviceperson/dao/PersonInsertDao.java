package com.ccbtrust.serviceperson.dao;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;



/**
 * 添加数据操作
 * @author nzhang
 */
public interface PersonInsertDao {
    /**
     * 增加员工
     * @param  personInsertDTO 员工信息DTO
     * @return 反回插入的行数
     *
     */
    int insert(PersonInsertDTO personInsertDTO);


}
