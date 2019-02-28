package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.remoteclient.exception.PersonException;
import com.ccbtrust.serviceperson.dao.PersonDeleteDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.generator.tables.Person.PERSON;
/**
 * 删除员工
 * @author nzhang
 */
@Repository
public class PersonDeleteDaoImpl implements PersonDeleteDao {
  @Autowired
   private DSLContext dslContext;

    @Override
    public int deleteById(int id) {
         int effectNum = dslContext.update(PERSON).set(PERSON.DELETE_FLAG,1).set(PERSON.DELETE_PERSON,"Tom").set(PERSON.DELETE_TIME, LocalDateTime.now()).where(PERSON.ID.eq(id)).execute();
         return effectNum;
    }
}
