package com.ccbtrust.apiperson.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(min = 18,max = 18)
    private String             cardNum;
    @NotBlank
    @Size(min = 11,max = 11)
    private String             phoneNum;
}
