package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import com.ccbtrust.serviceperson.dao.PersonSelectDao;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.generator.tables.Person.PERSON;

/**
 * 查询员工
 * @author nzhang
 */
@Repository
public class PersonSelectDaoImpl implements PersonSelectDao {
    @Autowired
    private DSLContext dslContext;

    /**
     *根据员工id查询员工
     * @param id 员工id
     * @return 查询到的员工信息
     */
    @Override
    public PersonSelectResultDTO selectById(int id) {
        List<PersonSelectResultDTO> personList = dslContext.select().from(PERSON).where(PERSON.ID.eq(id).and(PERSON.DELETE_FLAG.eq(0))).fetchInto(PersonSelectResultDTO.class);
        return personList.get(0);
    }


    /**
     * 根据证件号码查询员工
     * @param cardNum  员工证件号码
     * @return 查询到的员工信息
     */
    @Override
    public PersonSelectResultDTO selectByCardNum(String cardNum) {
        List<PersonSelectResultDTO> personList = dslContext.select().from(PERSON).where(PERSON.CARD_NUM.eq(cardNum).and(PERSON.DELETE_FLAG.eq(0))).fetchInto(PersonSelectResultDTO.class);
        return personList.get(0);
    }

    /**
     * 分页查询所有员工
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 查询到的所有员工列表
     */
    @Override
    public List<PersonSelectResultDTO> selectAll(int pageNum, int pageSize) {
        List<PersonSelectResultDTO> personSelectResultDTOList = dslContext.select().from(PERSON).where(PERSON.DELETE_FLAG.eq(0)).limit(pageSize).offset(pageSize*(pageNum-1)).fetchInto(PersonSelectResultDTO.class);
        return personSelectResultDTOList;
    }

    /**
     * 根据组合条件查找员工
     * @param personSelectConditionsDTO  组合查询条件
     * @return 查询到的员工信息
     */
    @Override
    public List<PersonSelectResultDTO> selectByConditions(PersonSelectConditionsDTO personSelectConditionsDTO) {
        List<Condition> conditions = new ArrayList<>();
        if (personSelectConditionsDTO.getPersonName()!=null){
            conditions.add(PERSON.PERSON_NAME.eq(personSelectConditionsDTO.getPersonName()));
        }
        if (personSelectConditionsDTO.getCardType()!=null){
            conditions.add(PERSON.CARD_TYPE.eq(personSelectConditionsDTO.getCardType()));
        }
        if (personSelectConditionsDTO.getCreatePerson()!=null){
            conditions.add(PERSON.CREATE_PERSON.eq(personSelectConditionsDTO.getCreatePerson()));
        }
        if (personSelectConditionsDTO.getCreateTime()!=null){
            conditions.add(PERSON.CREATE_TIME.greaterOrEqual(personSelectConditionsDTO.getCreateTime()));
        }
        conditions.add(PERSON.DELETE_FLAG.eq(0));
        List<PersonSelectResultDTO> personSelectResultDTOList = dslContext.select().from(PERSON).where(conditions).limit(personSelectConditionsDTO.getPageSize()).offset((personSelectConditionsDTO.getPageNum() - 1) * personSelectConditionsDTO.getPageSize()).fetchInto(PersonSelectResultDTO.class);
        return personSelectResultDTOList;
    }


}
