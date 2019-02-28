package com.ccbtrust.serviceperson.dao;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;



/**
 * @author nzhang
 */
public interface PersonInsertDao {
    /**
     * 增加员工
     * @param  personInsertDTO 员工信息
     * @return 反回插入的行数
     *
     */
    int insert(PersonInsertDTO personInsertDTO);


}
