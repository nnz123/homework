package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonDeleteDao;
import com.ccbtrust.serviceperson.service.PersonDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


/**
 * 删除员工
 * @author nzhang
 */
@Service
public class PersonDeleteServiceImpl implements PersonDeleteService {
    @Autowired
    private PersonDeleteDao personDeleteDao;

    @Override
    public void deleteById(int id,String deletePerson){
        Assert.notNull(deletePerson,"删除人姓名不能为null");
            int effectNum;
            try {
                 effectNum = personDeleteDao.deleteById(id,deletePerson);
                if (effectNum<=0){
                    throw new PersonException("将要删除的员工不存在");
                }
            }catch (Exception e){
                throw new PersonException(e.getMessage());
            }
    }
}
