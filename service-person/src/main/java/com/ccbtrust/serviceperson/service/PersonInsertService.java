package com.ccbtrust.serviceperson.service;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import java.util.Map;

/**
 * 添加操作
 * @author nzhang
 */
public interface PersonInsertService {
    /**
     * 增加员工
     * @param  personInsertDTO 员工信息
     *
     */
     void addPerson(PersonInsertDTO personInsertDTO);





}
