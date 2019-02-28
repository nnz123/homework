package com.ccbtrust.serviceperson.dao;

/**
 * 删除员工
 * @author nzhang
 */
public interface PersonDeleteDao {
    /**
     * 通过id删除员工
     * @param id 员工id
     * @return  返回删除的行数
     */
    int deleteById(int id);
}
