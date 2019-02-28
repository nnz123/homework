package com.ccbtrust.apiperson.model;

import lombok.Data;

/**
 * @author nzhang
 */
@Data
public class PersonInsertVO {
    private String             personName;
    private Integer            cardType;
    private String             cardNum;
    private String             phoneNum;
}
