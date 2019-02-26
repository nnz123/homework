package com.ccbtrust.serviceperson.service;


import com.ccbtrust.serviceperson.entity.PersonInsert;

/**
 * @author nzhang
 */
public interface PersonService {
    /**
     * 增加员工
     * @param  personInsert 员工信息
     */
    void insert(PersonInsert personInsert);

    /**
     * 通过id删除员工
     * @param id 员工id
     */
    void deleteById(int id);



}
