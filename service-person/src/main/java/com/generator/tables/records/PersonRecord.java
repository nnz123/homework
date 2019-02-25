/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.enums.PersonCardType;
import com.generator.enums.PersonPersonStatus;
import com.generator.tables.Person;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record14<Integer, String, PersonCardType, String, String, String, PersonPersonStatus, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, Byte> {

    private static final long serialVersionUID = 1467151189;

    /**
     * Setter for <code>homework.person.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>homework.person.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>homework.person.person_name</code>. 员工姓名
     */
    public void setPersonName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>homework.person.person_name</code>. 员工姓名
     */
    public String getPersonName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>homework.person.card_type</code>. 员工证件类型0身份证1护照
     */
    public void setCardType(PersonCardType value) {
        set(2, value);
    }

    /**
     * Getter for <code>homework.person.card_type</code>. 员工证件类型0身份证1护照
     */
    public PersonCardType getCardType() {
        return (PersonCardType) get(2);
    }

    /**
     * Setter for <code>homework.person.card_num</code>. 证件号码
     */
    public void setCardNum(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>homework.person.card_num</code>. 证件号码
     */
    public String getCardNum() {
        return (String) get(3);
    }

    /**
     * Setter for <code>homework.person.person_picture</code>. 员工头像
     */
    public void setPersonPicture(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>homework.person.person_picture</code>. 员工头像
     */
    public String getPersonPicture() {
        return (String) get(4);
    }

    /**
     * Setter for <code>homework.person.phone_num</code>. 员工电话
     */
    public void setPhoneNum(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>homework.person.phone_num</code>. 员工电话
     */
    public String getPhoneNum() {
        return (String) get(5);
    }

    /**
     * Setter for <code>homework.person.person_status</code>. 0在职，1 离职
     */
    public void setPersonStatus(PersonPersonStatus value) {
        set(6, value);
    }

    /**
     * Getter for <code>homework.person.person_status</code>. 0在职，1 离职
     */
    public PersonPersonStatus getPersonStatus() {
        return (PersonPersonStatus) get(6);
    }

    /**
     * Setter for <code>homework.person.create_person</code>. 员工信息创建人
     */
    public void setCreatePerson(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>homework.person.create_person</code>. 员工信息创建人
     */
    public String getCreatePerson() {
        return (String) get(7);
    }

    /**
     * Setter for <code>homework.person.create_time</code>. 员工信息创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>homework.person.create_time</code>. 员工信息创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>homework.person.edit_person</code>. 员工信息修改人
     */
    public void setEditPerson(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>homework.person.edit_person</code>. 员工信息修改人
     */
    public String getEditPerson() {
        return (String) get(9);
    }

    /**
     * Setter for <code>homework.person.edit_time</code>. 员工信息修改时间
     */
    public void setEditTime(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>homework.person.edit_time</code>. 员工信息修改时间
     */
    public LocalDateTime getEditTime() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>homework.person.delete_person</code>. 员工信息删除人
     */
    public void setDeletePerson(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>homework.person.delete_person</code>. 员工信息删除人
     */
    public String getDeletePerson() {
        return (String) get(11);
    }

    /**
     * Setter for <code>homework.person.delete_time</code>. 员工信息删除时间
     */
    public void setDeleteTime(LocalDateTime value) {
        set(12, value);
    }

    /**
     * Getter for <code>homework.person.delete_time</code>. 员工信息删除时间
     */
    public LocalDateTime getDeleteTime() {
        return (LocalDateTime) get(12);
    }

    /**
     * Setter for <code>homework.person.delete_flag</code>. 删除标记
     */
    public void setDeleteFlag(Byte value) {
        set(13, value);
    }

    /**
     * Getter for <code>homework.person.delete_flag</code>. 删除标记
     */
    public Byte getDeleteFlag() {
        return (Byte) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Integer, String, PersonCardType, String, String, String, PersonPersonStatus, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, Byte> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Integer, String, PersonCardType, String, String, String, PersonPersonStatus, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, Byte> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Person.PERSON.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Person.PERSON.PERSON_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<PersonCardType> field3() {
        return Person.PERSON.CARD_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Person.PERSON.CARD_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Person.PERSON.PERSON_PICTURE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Person.PERSON.PHONE_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<PersonPersonStatus> field7() {
        return Person.PERSON.PERSON_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Person.PERSON.CREATE_PERSON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field9() {
        return Person.PERSON.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Person.PERSON.EDIT_PERSON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field11() {
        return Person.PERSON.EDIT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Person.PERSON.DELETE_PERSON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field13() {
        return Person.PERSON.DELETE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field14() {
        return Person.PERSON.DELETE_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPersonName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonCardType value3() {
        return getCardType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCardNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPersonPicture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPhoneNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonPersonStatus value7() {
        return getPersonStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCreatePerson();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value9() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getEditPerson();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value11() {
        return getEditTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getDeletePerson();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value13() {
        return getDeleteTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value14() {
        return getDeleteFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value2(String value) {
        setPersonName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value3(PersonCardType value) {
        setCardType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value4(String value) {
        setCardNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value5(String value) {
        setPersonPicture(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value6(String value) {
        setPhoneNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value7(PersonPersonStatus value) {
        setPersonStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value8(String value) {
        setCreatePerson(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value9(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value10(String value) {
        setEditPerson(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value11(LocalDateTime value) {
        setEditTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value12(String value) {
        setDeletePerson(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value13(LocalDateTime value) {
        setDeleteTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value14(Byte value) {
        setDeleteFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord values(Integer value1, String value2, PersonCardType value3, String value4, String value5, String value6, PersonPersonStatus value7, String value8, LocalDateTime value9, String value10, LocalDateTime value11, String value12, LocalDateTime value13, Byte value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(Integer id, String personName, PersonCardType cardType, String cardNum, String personPicture, String phoneNum, PersonPersonStatus personStatus, String createPerson, LocalDateTime createTime, String editPerson, LocalDateTime editTime, String deletePerson, LocalDateTime deleteTime, Byte deleteFlag) {
        super(Person.PERSON);

        set(0, id);
        set(1, personName);
        set(2, cardType);
        set(3, cardNum);
        set(4, personPicture);
        set(5, phoneNum);
        set(6, personStatus);
        set(7, createPerson);
        set(8, createTime);
        set(9, editPerson);
        set(10, editTime);
        set(11, deletePerson);
        set(12, deleteTime);
        set(13, deleteFlag);
    }
}
