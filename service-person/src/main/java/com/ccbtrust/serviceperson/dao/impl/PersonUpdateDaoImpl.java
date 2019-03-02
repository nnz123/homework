package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.remoteclient.model.PersonUpdateDTO;
import com.ccbtrust.serviceperson.dao.PersonUpdateDao;
import com.generator.tables.records.PersonRecord;
import org.jooq.DSLContext;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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

    @Override
    public int updatePersonInfo(PersonUpdateDTO personUpdateDTO) {
        UpdateSetMoreStep<PersonRecord> updateSet = dslContext.update(PERSON).set(PERSON.EDIT_TIME, LocalDateTime.now());
        if (personUpdateDTO.getPersonName()!=null) {
           updateSet.set(PERSON.PERSON_NAME, personUpdateDTO.getPersonName());
        }
        if (personUpdateDTO.getCardType()!=null){
            updateSet = updateSet.set(PERSON.CARD_TYPE,personUpdateDTO.getCardType());
        }
        if (personUpdateDTO.getCardNum()!=null){
            updateSet = updateSet.set(PERSON.CARD_NUM,personUpdateDTO.getCardNum());
        }
        if (personUpdateDTO.getPhoneNum()!=null){
            updateSet = updateSet.set(PERSON.PHONE_NUM,personUpdateDTO.getPhoneNum());
        }
        if (personUpdateDTO.getEditPerson()!=null){
            updateSet = updateSet.set(PERSON.EDIT_PERSON,personUpdateDTO.getEditPerson());
        }
        return updateSet.where(PERSON.ID.eq(personUpdateDTO.getId())).execute();
    }
}
