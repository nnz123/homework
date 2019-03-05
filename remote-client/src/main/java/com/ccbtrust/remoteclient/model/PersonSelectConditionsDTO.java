package com.ccbtrust.remoteclient.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import com.ccbtrust.remoteclient.enums.PersonStatus;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 员工组合查询时的查询条件
 * @author nzhang
 */
@Data
public class PersonSelectConditionsDTO {
    private String            personName;
    private PersonCardType    cardType;
    private PersonStatus      personStatus;
    private String            createPerson;
    private LocalDateTime     createTime;
    private String            editPerson;
    private Integer           pageNum;
    private Integer           pageSize;
}
