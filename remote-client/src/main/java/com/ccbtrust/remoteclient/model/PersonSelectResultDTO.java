package com.ccbtrust.remoteclient.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import com.ccbtrust.remoteclient.enums.PersonStatus;
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
    private Integer        id;
    private String         personName;
    private PersonCardType cardType;
    private String         cardNum;
    private String         personPicture;
    private String         phoneNum;
    private PersonStatus   personStatus;
    private String         createPerson;
    private LocalDateTime  createTime;
    private String         editPerson;
    private LocalDateTime  editTime;
    private String         deletePerson;
    private LocalDateTime  deleteTime;
    private Integer        deleteFlag;

}
