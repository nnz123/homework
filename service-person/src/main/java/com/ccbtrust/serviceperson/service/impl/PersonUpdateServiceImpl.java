package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.serviceperson.dao.PersonUpdateDao;
import com.ccbtrust.serviceperson.service.PersonUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 更新员工信息
 * @author nzhang
 */
@Service
public class PersonUpdateServiceImpl implements PersonUpdateService {

    @Autowired
    private PersonUpdateDao personUpdateDao;

    @Override
    public void uploadPicture(int id, String localPictureAddr) {
        Assert.notNull(localPictureAddr,"头像存储地址不能为null");
        try {
            int effectNum = personUpdateDao.uploadPicture(id, localPictureAddr);
            if (effectNum<=0){
                throw new PersonException("该员工不存在");
            }
        } catch (Exception e) {
            throw new PersonException(e.getMessage());
        }
    }

    @Override
    public void updatePersonInfo(PersonUpdateDTO personUpdateDTO) {
        Assert.notNull(personUpdateDTO,"员工基本信息不能为null");
        try {
            int effectNum = personUpdateDao.updatePersonInfo(personUpdateDTO);
            if (effectNum<=0){
                throw new PersonException("该员工不存在");
            }
        } catch (Exception e) {
            throw  new PersonException(e.getMessage());
        }
    }
}
