package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonLeaveDao;
import com.ccbtrust.serviceperson.service.PersonLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 员工离职
 * @author nzhang
 */
@Service
public class PersonLeaveServiceImpl implements PersonLeaveService {
    @Autowired
    private PersonLeaveDao personLeaveDao;

    @Override
    public void leave(int id,String editPerson) {
        Assert.notNull(editPerson,"操作人姓名不能为null");
        try {
            int  effectNum = personLeaveDao.leave(id,editPerson);
            if (effectNum<=0){
                throw new PersonException("该员工不存在");
            }
        }catch (Exception e){
            throw new PersonException(e.getMessage());
        }
    }
}
