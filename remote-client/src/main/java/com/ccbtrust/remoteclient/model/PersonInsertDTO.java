package com.ccbtrust.remoteclient.model;

import lombok.Data;

/**
 * @author nzhang
 */
@Data
public class PersonInsertDTO {

    private String             personName;
    private Integer            cardType;
    private String             cardNum;
    private String             personPicture;
    private String             phoneNum;
    private String             createPerson;

}
