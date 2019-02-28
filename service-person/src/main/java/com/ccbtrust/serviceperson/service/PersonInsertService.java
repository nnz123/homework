package com.ccbtrust.serviceperson.service;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import java.util.Map;

/**
 * @author nzhang
 */
public interface PersonInsertService {
    /**
     * 增加员工
     * @param  personInsertDTO 员工信息
     * @return 反回插入的行数
     *
     */
     Map<String,Object> insert(PersonInsertDTO personInsertDTO);





}
