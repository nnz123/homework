package com.ccbtrust.serviceperson.dao.impl;

import com.ccbtrust.remoteclient.enums.PersonStatus;
import com.ccbtrust.serviceperson.dao.PersonLeaveDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.generator.tables.Person.PERSON;
/**
 * 员工离职
 * @author nzhang
 *
 */
@Repository
public class PersonLeaveDaoImpl implements PersonLeaveDao {
    @Autowired
    private DSLContext dslContext;

    @Override
    public int leave(Integer id,String editPerson) {
        return  dslContext.update(PERSON).set(PERSON.PERSON_STATUS, PersonStatus.LeaveOffice).set(PERSON.EDIT_PERSON,editPerson).set(PERSON.EDIT_TIME, LocalDateTime.now()).where(PERSON.ID.eq(id).and(PERSON.DELETE_FLAG.eq(0))).execute();

    }
}
