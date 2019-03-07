package com.ccbtrust.serviceperson.service.impl;

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
 *
 * @author nzhang
 */
@Service
public class PersonSelectServiceImpl implements PersonSelectService {
    @Autowired
    private PersonSelectDao personSelectDao;

    @Override
    public PersonSelectResultDTO selectById(Integer id) {
        Assert.notNull(id, "员工id不能为空");
        return personSelectDao.selectById(id);
    }

    @Override
    public PersonSelectResultDTO selectByCardNum(String cardNum) {
        Assert.notNull(cardNum, "证件号码不能为空");
        return personSelectDao.selectByCardNum(cardNum);
    }

    @Override
    public List<PersonSelectResultDTO> selectAll(Integer pageNum, Integer pageSize) {
        Assert.notNull(pageNum, "页码不能为空");
        Assert.notNull(pageSize, "每页显示的内容不能为空");
        return personSelectDao.selectAll(pageNum, pageSize);
    }

    @Override
    public List<PersonSelectResultDTO> selectByConditions(PersonSelectConditionsDTO personSelectConditionsDTO) {
        Assert.notNull(personSelectConditionsDTO.getPageNum(), "页码不能为空");
        Assert.notNull(personSelectConditionsDTO.getPageSize(), "每页显示的条数不能为空");
        return personSelectDao.selectByConditions(personSelectConditionsDTO);
    }
}
