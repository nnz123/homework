package com.ccbtrust.serviceperson.service.impl;

import com.ccbtrust.serviceperson.entity.PersonInsert;
import com.ccbtrust.serviceperson.service.PersonService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Timestamp;

import static com.generator.tables.Person.PERSON;
/**
 * @author nzhang
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    DSLContext dslContext;

    @Override
    public void insert(PersonInsert personInsert) {
        dslContext.insertInto(PERSON)
                .columns(PERSON.PERSON_NAME,PERSON.CARD_TYPE,PERSON.CARD_NUM,PERSON.PERSON_PICTURE,PERSON.PHONE_NUM,PERSON.CREATE_PERSON)
                .values(personInsert.getPersonName(),personInsert.getCardType(),personInsert.getCardNum(),personInsert.getPersonPicture(),personInsert.getPhoneNum(),personInsert.getCreatePerson()).execute();

    }

    @Override
    public void deleteById(int id) {
        dslContext.deleteFrom(PERSON).where(PERSON.ID.eq(id)).execute();
    }

}
