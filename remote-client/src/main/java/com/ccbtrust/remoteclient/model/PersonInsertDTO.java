package com.ccbtrust.remoteclient.model;


import com.ccbtrust.remoteclient.enums.PersonCardType;
import lombok.Data;

/**
 * 增加员工DTO
 * @author nzhang
 */
@Data
public class PersonInsertDTO {
    private String             personName;
    private PersonCardType     cardType;
    private String             cardNum;
    private String             personPicture;
    private String             phoneNum;
    private String             createPerson;

}
