package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import com.ccbtrust.serviceperson.dao.PersonSelectDao;
import com.ccbtrust.serviceperson.service.PersonSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
            List<PersonSelectResultDTO> personSelectResultDTOList = personSelectDao.selectById(id);
            if (personSelectResultDTOList.size()==0){
                throw new PersonException("该员工不存在！");
            }
            personSelectResultDTO= personSelectResultDTOList.get(0);
        } catch (Exception e) {
           throw new PersonException(e.getMessage());
        }
        return personSelectResultDTO;
    }

    @Override
    public PersonSelectResultDTO selectByCardNum(String cardNum) {
        PersonSelectResultDTO personSelectResultDTO;
        try {
            List<PersonSelectResultDTO> personSelectResultDTOList = personSelectDao.selectByCardNum(cardNum);
            if (personSelectResultDTOList.size()==0){
                throw new PersonException("该员工不存在！");
            }
            personSelectResultDTO = personSelectResultDTOList.get(0);
        } catch (Exception e) {
            throw new PersonException(e.getMessage());
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
