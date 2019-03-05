package com.ccbtrust.serviceperson.dao;

/**
 * 删除员工
 * @author nzhang
 */
public interface PersonDeleteDao {
    /**
     * 通过id删除员工
     * @param id 员工id
     * @param deletePerson 删除人姓名
     * @return  返回删除的行数
     */
    int deleteById(Integer id,String deletePerson);
}
