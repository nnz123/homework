package com.ccbtrust.serviceperson.dao;
import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;

import java.util.List;

/**
 * 查询员工
 * @author nzhang
 */
public interface PersonSelectDao{
    /**
     * 根据员工id查询员工
     * @param id 员工id
     * @return 查询到的员工信息
     */
    List<PersonSelectResultDTO> selectById(Integer id);

    /**
     * 根据员工证件号码查询员工
     * @param cardNum  员工证件号码
     * @return 查询到的员工信息
     */
    List<PersonSelectResultDTO> selectByCardNum(String cardNum);

    /**
     * 分页查询所有员工信息
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return  查询到的结果
     */
    List<PersonSelectResultDTO> selectAll(Integer pageNum, Integer pageSize);

    /**
     * 根据组合条件查找员工
     * @param personSelectConditionsDTO  组合查询条件
     * @return 查询到的员工信息
     */
    List<PersonSelectResultDTO> selectByConditions(PersonSelectConditionsDTO personSelectConditionsDTO);

}
