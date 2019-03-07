package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonDeleteDao;
import com.ccbtrust.serviceperson.service.PersonDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


/**
 * 删除员工
 *
 * @author nzhang
 */
@Service
public class PersonDeleteServiceImpl implements PersonDeleteService {
    @Autowired
    private PersonDeleteDao personDeleteDao;

    @Override
    public void deleteById(Integer id, String deletePerson) {
        Assert.notNull(deletePerson, "删除人姓名不能为空");
        Assert.notNull(id, "被删除人的id不能为空");
        int effectNum = personDeleteDao.deleteById(id, deletePerson);
        if (effectNum <= 0) {
            throw new PersonException("将要删除的员工不存在！");
        }
    }
}
