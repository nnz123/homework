package com.ccbtrust.serviceperson.service.impl;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonInsertDao;
import com.ccbtrust.serviceperson.dao.PersonSelectDao;
import com.ccbtrust.serviceperson.service.PersonInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 添加操作
 *
 * @author nzhang
 */
@Service
public class PersonInsertServiceImpl implements PersonInsertService {

    @Autowired
    private PersonInsertDao personInsertDao;
    @Autowired
    private PersonSelectDao personSelectDao;

    @Override
    public void addPerson(PersonInsertDTO personInsertDTO) {
        Assert.notNull(personInsertDTO.getPersonName(), "员工姓名不能为空");
        Assert.notNull(personInsertDTO.getCardType(), "证件类型不能为空");
        Assert.notNull(personInsertDTO.getCardNum(), "证件号码不可以为空");
        Assert.notNull(personInsertDTO.getCreatePerson(), "信息添加人不能为空");
        //通过证件号码判断员工是否已经存在
        if (personSelectDao.selectByCardNum(personInsertDTO.getCardNum()) != null) {
            throw new PersonException("该员工已经存在!");
        }
        //添加员工
        int effectNum = personInsertDao.insert(personInsertDTO);
        if (effectNum <= 0) {
            throw new PersonException("添加员工失败");
        }
    }
}
