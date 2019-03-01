package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonLeaveDao;
import com.ccbtrust.serviceperson.service.PersonLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int effectNum;
        try {
            effectNum = personLeaveDao.leave(id,editPerson);
            if (effectNum<=0){
                throw new PersonException("更改员工状态失败");
            }
        }catch (Exception e){
            throw new PersonException(e.getMessage());
        }
    }
}
