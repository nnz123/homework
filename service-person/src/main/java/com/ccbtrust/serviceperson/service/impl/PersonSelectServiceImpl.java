package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import com.ccbtrust.serviceperson.dao.PersonSelectDao;
import com.ccbtrust.serviceperson.service.PersonSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询员工
 * @author nzhang
 */
@Service
public class PersonSelectServiceImpl implements PersonSelectService {
    @Autowired
    private PersonSelectDao personSelectDao;

    @Override
    public PersonSelectResultDTO selectById(int id) {
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO= personSelectDao.selectById(id);
        } catch (Exception e) {
           throw new PersonException("员工不存在");
        }
        return personSelectResultDTO;
    }

    @Override
    public PersonSelectResultDTO selectByCardNum(String cardNum) {
        PersonSelectResultDTO personSelectResultDTO;
        try {
            personSelectResultDTO= personSelectDao.selectByCardNum(cardNum);
        } catch (Exception e) {
            throw new PersonException("员工不存在"+e.getMessage());
        }
        return personSelectResultDTO;
    }

    @Override
    public List<PersonSelectResultDTO> selectAll(int pageNum, int pageSize) {
        List<PersonSelectResultDTO> personSelectResultDTOList;

        try {
            personSelectResultDTOList = personSelectDao.selectAll(pageNum, pageSize);
        } catch (Exception e) {
            throw new PersonException("查询失败"+e.getMessage());
        }
        return personSelectResultDTOList;
    }

    @Override
    public List<PersonSelectResultDTO> selectByConditions(PersonSelectConditionsDTO personSelectConditionsDTO) {

        List<PersonSelectResultDTO> personSelectResultDTOList;
        try {
            personSelectResultDTOList = personSelectDao.selectByConditions(personSelectConditionsDTO);
        } catch (Exception e) {
            throw  new PersonException("查询失败"+e.getMessage());
        }
        return personSelectResultDTOList;
    }
}
