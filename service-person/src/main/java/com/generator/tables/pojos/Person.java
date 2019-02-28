/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


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
public class Person implements Serializable {

    private static final long serialVersionUID = 485940616;

    private Integer       id;
    private String        personName;
    private Integer       cardType;
    private String        cardNum;
    private String        personPicture;
    private String        phoneNum;
    private Integer       personStatus;
    private String        createPerson;
    private LocalDateTime createTime;
    private String        editPerson;
    private LocalDateTime editTime;
    private String        deletePerson;
    private LocalDateTime deleteTime;
    private Byte          deleteFlag;

    public Person() {}

    public Person(Person value) {
        this.id = value.id;
        this.personName = value.personName;
        this.cardType = value.cardType;
        this.cardNum = value.cardNum;
        this.personPicture = value.personPicture;
        this.phoneNum = value.phoneNum;
        this.personStatus = value.personStatus;
        this.createPerson = value.createPerson;
        this.createTime = value.createTime;
        this.editPerson = value.editPerson;
        this.editTime = value.editTime;
        this.deletePerson = value.deletePerson;
        this.deleteTime = value.deleteTime;
        this.deleteFlag = value.deleteFlag;
    }

    public Person(
        Integer       id,
        String        personName,
        Integer       cardType,
        String        cardNum,
        String        personPicture,
        String        phoneNum,
        Integer       personStatus,
        String        createPerson,
        LocalDateTime createTime,
        String        editPerson,
        LocalDateTime editTime,
        String        deletePerson,
        LocalDateTime deleteTime,
        Byte          deleteFlag
    ) {
        this.id = id;
        this.personName = personName;
        this.cardType = cardType;
        this.cardNum = cardNum;
        this.personPicture = personPicture;
        this.phoneNum = phoneNum;
        this.personStatus = personStatus;
        this.createPerson = createPerson;
        this.createTime = createTime;
        this.editPerson = editPerson;
        this.editTime = editTime;
        this.deletePerson = deletePerson;
        this.deleteTime = deleteTime;
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getCardType() {
        return this.cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPersonPicture() {
        return this.personPicture;
    }

    public void setPersonPicture(String personPicture) {
        this.personPicture = personPicture;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getPersonStatus() {
        return this.personStatus;
    }

    public void setPersonStatus(Integer personStatus) {
        this.personStatus = personStatus;
    }

    public String getCreatePerson() {
        return this.createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getEditPerson() {
        return this.editPerson;
    }

    public void setEditPerson(String editPerson) {
        this.editPerson = editPerson;
    }

    public LocalDateTime getEditTime() {
        return this.editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public String getDeletePerson() {
        return this.deletePerson;
    }

    public void setDeletePerson(String deletePerson) {
        this.deletePerson = deletePerson;
    }

    public LocalDateTime getDeleteTime() {
        return this.deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Byte getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person (");

        sb.append(id);
        sb.append(", ").append(personName);
        sb.append(", ").append(cardType);
        sb.append(", ").append(cardNum);
        sb.append(", ").append(personPicture);
        sb.append(", ").append(phoneNum);
        sb.append(", ").append(personStatus);
        sb.append(", ").append(createPerson);
        sb.append(", ").append(createTime);
        sb.append(", ").append(editPerson);
        sb.append(", ").append(editTime);
        sb.append(", ").append(deletePerson);
        sb.append(", ").append(deleteTime);
        sb.append(", ").append(deleteFlag);

        sb.append(")");
        return sb.toString();
    }
}
