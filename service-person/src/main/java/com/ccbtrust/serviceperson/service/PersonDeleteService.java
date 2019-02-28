package com.ccbtrust.serviceperson.service;

import java.util.Map;

/**
 * 根据id删除员工
 * @author nzhang
 */
public interface PersonDeleteService {
    /**
     * 通过id删除员工
     * @param id 员工id
     * @return 返回删除的信息条数
     */
   void deleteById(int id);
}
