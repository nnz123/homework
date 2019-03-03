package com.ccbtrust.remoteclient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 员工组合查询时的查询条件
 * @author nzhang
 */
@Data
public class PersonSelectConditionsDTO {
    private String        personName;
    private Integer       cardType;
    private String        createPerson;
    private LocalDateTime     createTime;
    private Integer       pageNum;
    private Integer       pageSize;
}
