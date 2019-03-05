package com.ccbtrust.serviceperson.dao;


/**
 * 员工离职
 * @author nzhang
 */
public interface PersonLeaveDao {
    /**
     * 员工离职
     * @param id 员工
     * @param editPerson 修改人
     * @return 反回修改的信息条数
     */
    int leave(Integer id,String editPerson);
}
