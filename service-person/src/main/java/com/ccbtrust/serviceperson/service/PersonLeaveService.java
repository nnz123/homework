package com.ccbtrust.serviceperson.service;

/**
 * 员工离职
 * @author nzhang
 */
public interface PersonLeaveService {
    /**
     * 员工离职
     * @param id 员工id
     * @param  editPerson 操作人姓名
     */
    void leave(Integer id,String editPerson);
}
