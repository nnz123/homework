package com.ccbtrust.remoteclient.model;

import lombok.Data;

/**
 * 跟新员工基本信息DTO
 * @author nzhang
 */
@Data
public class PersonUpdateDTO {
    private Integer            id;
    private String             personName;
    private Integer            cardType;
    private String             cardNum;
    private String             phoneNum;
    private String             editPerson;

}
