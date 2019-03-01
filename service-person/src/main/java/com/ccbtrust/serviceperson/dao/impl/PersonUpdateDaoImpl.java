package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.serviceperson.dao.PersonUpdateDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.generator.tables.Person.PERSON;
/**
 * 更新员工信息
 * @author nzhang
 */
@Repository
public class PersonUpdateDaoImpl implements PersonUpdateDao {

    @Autowired
    private DSLContext dslContext;
    @Override
    public int uploadPicture(int id, String localPictureAddr) {
        return dslContext.update(PERSON).set(PERSON.PERSON_PICTURE, localPictureAddr).where(PERSON.ID.eq(id)).execute();
    }
}
