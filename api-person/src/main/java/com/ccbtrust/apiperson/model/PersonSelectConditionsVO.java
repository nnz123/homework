package com.ccbtrust.apiperson.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

/**
 * @author nzhang
 */
@Data
public class PersonSelectConditionsVO {
    private String        personName;
    private Integer       cardType;
    private String        createPerson;

    /**
     * 查询在这个日期之后添加的
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private Integer       pageNum;
    private Integer       pageSize;
}
