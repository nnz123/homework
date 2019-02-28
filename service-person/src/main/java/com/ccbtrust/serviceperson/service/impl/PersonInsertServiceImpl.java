package com.ccbtrust.serviceperson.service.impl;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonInsertDao;
import com.ccbtrust.serviceperson.service.PersonInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

/**
 * @author nzhang
 */
@Service
public class PersonInsertServiceImpl implements PersonInsertService {

    @Autowired
    private PersonInsertDao personInsertDao;

    @Override
    public void insert(PersonInsertDTO personInsertDTO) {
        try {
            int effectNum = personInsertDao.insert(personInsertDTO);
            if (effectNum <= 0) {
                throw new PersonException("添加员工失败");
            }
        }catch (Exception e){
            throw new PersonException(e.getMessage());
        }
    }

}
