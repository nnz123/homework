package com.ccbtrust.remoteclient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 员工查询DTO
 * @author nzhang
 */
@Data
public class PersonSelectResultDTO {

    private Integer       id;
    private String        personName;
    private Integer       cardType;
    private String        cardNum;
    private String        personPicture;
    private String        phoneNum;
    private String        createPerson;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;
    private String        editPerson;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime editTime;
    private String        deletePerson;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime deleteTime;
    private Integer       deleteFlag;

}