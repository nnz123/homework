package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.serviceperson.dao.PersonInsertDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.generator.tables.Person.PERSON;


/**
 * @author nzhang
 */
@Repository
public class PersonInsertDaoImpl implements PersonInsertDao {
    @Autowired
    private DSLContext dslContext;

    @Override
    public int insert(PersonInsertDTO personInsertDTO) {
        int effectNum = dslContext.insertInto(PERSON)
                .columns(PERSON.PERSON_NAME, PERSON.CARD_TYPE, PERSON.CARD_NUM, PERSON.PERSON_PICTURE, PERSON.PHONE_NUM, PERSON.CREATE_PERSON)
                .values(personInsertDTO.getPersonName(), personInsertDTO.getCardType(), personInsertDTO.getCardNum(), personInsertDTO.getPersonPicture(), personInsertDTO.getPhoneNum(), personInsertDTO.getCreatePerson()).execute();
        return effectNum;
    }

    @Override
    public int deleteById(int id) {
        int effectNum = dslContext.deleteFrom(PERSON).where(PERSON.ID.eq(id)).execute();
        return effectNum;

    }

    @Override
    public int updatePersonPicture(PersonInsertDTO personInsertDTO) {
        int effectNum = dslContext.update(PERSON).set(PERSON.PERSON_PICTURE, personInsertDTO.getPersonPicture()).where(PERSON.CARD_NUM.eq(personInsertDTO.getCardNum())).execute();
        return effectNum;
    }
}
