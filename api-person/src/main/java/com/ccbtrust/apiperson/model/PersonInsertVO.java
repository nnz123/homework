package com.ccbtrust.apiperson.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nzhang
 */
@Data
public class PersonInsertVO {
    @NotBlank
    private String             personName;
    @NotNull
    private Integer            cardType;
    @NotBlank
    private String             cardNum;
    @NotBlank
    private String             phoneNum;
}
