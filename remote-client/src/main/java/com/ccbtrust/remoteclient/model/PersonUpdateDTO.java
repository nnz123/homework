package com.ccbtrust.remoteclient.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import lombok.Data;

/**
 * 跟新员工基本信息DTO
 * @author nzhang
 */
@Data
public class PersonUpdateDTO {
    private Integer            id;
    private String             personName;
    private PersonCardType     cardType;
    private String             cardNum;
    private String             phoneNum;
    private String             editPerson;

}
