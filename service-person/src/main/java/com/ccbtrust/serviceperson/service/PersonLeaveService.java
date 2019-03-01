package com.ccbtrust.serviceperson.service;

/**
 * 员工离职
 * @author nzhang
 */
public interface PersonLeaveService {
    /**
     * 员工离职
     * @param id 员工id
     * @param  editPerson 修改人
     */
    void leave(int id,String editPerson);
}
