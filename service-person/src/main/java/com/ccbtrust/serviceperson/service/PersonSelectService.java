package com.ccbtrust.serviceperson.service;

import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;

import java.util.List;

/**
 * 查询员工
 * @author nzhang
 */
public interface PersonSelectService {
    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 反回查询到的员工
     */
    PersonSelectResultDTO selectById(int id);

    /**
     * 根据证件号码查询员工
     * @param cardNum 员工证件号码
     * @return 返回查询到员工信息
     */
    PersonSelectResultDTO selectByCardNum(String cardNum);

    /**
     * 分页查询所有员工
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 员工信息列表
     */
    List<PersonSelectResultDTO> selectAll(int pageNum, int pageSize);

    /**
     * 根据组合条件查询员工
     * @param personSelectConditionsDTO  查询员工的组合条件
     * @return 查询到的员工信息
     */
    List<PersonSelectResultDTO> selectByConditions(PersonSelectConditionsDTO personSelectConditionsDTO);
}
