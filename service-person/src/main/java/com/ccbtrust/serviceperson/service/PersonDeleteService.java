package com.ccbtrust.serviceperson.service;

/**
 * 根据id删除员工
 * @author nzhang
 */
public interface PersonDeleteService {
    /**
     * 通过id删除员工
     * @param id 员工id
     * @param deletePerson 删除操作者姓名
     */
   void deleteById(Integer id,String deletePerson);
}
