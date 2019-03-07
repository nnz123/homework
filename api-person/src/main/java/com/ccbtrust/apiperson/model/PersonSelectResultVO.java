package com.ccbtrust.apiperson.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import com.ccbtrust.remoteclient.enums.PersonStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nzhang
 */
@ApiModel("查询结果")
@Data
public class PersonSelectResultVO {
    @ApiModelProperty("员工id")
    private Integer       id;

    @ApiModelProperty("员工姓名")
    private String        personName;

    @ApiModelProperty("证件类型")
    private PersonCardType cardType;

    @ApiModelProperty("证件号码")
    private String        cardNum;

    @ApiModelProperty("电话号码")
    private String        phoneNum;

    @ApiModelProperty("是否在职")
    private PersonStatus personStatus;

    @ApiModelProperty("信息添加人")
    private String        createPerson;

    @ApiModelProperty("信息添加时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

}
