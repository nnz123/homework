package com.ccbtrust.apiperson.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import com.ccbtrust.remoteclient.enums.PersonStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author nzhang
 */
@ApiModel("查询条件")
@Data
public class PersonSelectConditionsVO {
    @ApiModelProperty(value = "员工姓名",example = "nn")
    private String         personName;
    @ApiModelProperty(value = "证件类型",example = "IdCard")
    private PersonCardType cardType;
    @ApiModelProperty(value = "员工状态",example = "InService")
    private PersonStatus   personStatus;
    @ApiModelProperty(value = "信息添加人",example = "Nancy")
    private String         createPerson;
    @ApiModelProperty(value = "信息添加时间",example = "2019-03-01 00:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "信息修改人",example = "Jack")
    private String        editPerson;


}
