package com.ccbtrust.serviceperson.entity;

import com.generator.enums.PersonCardType;
import com.generator.enums.PersonPersonStatus;
import lombok.Data;


/**
 * @author nzhang
 */
@Data
public class PersonInsert {
    private String             personName;
    private PersonCardType     cardType;
    private String             cardNum;
    private String             personPicture;
    private String             phoneNum;
    private String             createPerson;
}
