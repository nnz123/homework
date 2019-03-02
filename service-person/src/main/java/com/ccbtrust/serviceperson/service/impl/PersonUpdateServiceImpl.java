package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.serviceperson.dao.PersonUpdateDao;
import com.ccbtrust.serviceperson.service.PersonUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try {
            int effectNum = personUpdateDao.uploadPicture(id, localPictureAddr);
            if (effectNum<=0){
                throw new PersonException("保存员工头像地址失败");
            }
        } catch (Exception e) {
            throw new PersonException(e.getMessage());
        }
    }

    @Override
    public void updatePersonInfo(PersonUpdateDTO personUpdateDTO) {
        try {
            int effectNum = personUpdateDao.updatePersonInfo(personUpdateDTO);
            if (effectNum<=0){
                throw new PersonException("更新员工信息失败");
            }
        } catch (Exception e) {
            throw  new PersonException(e.getMessage());
        }
    }
}
