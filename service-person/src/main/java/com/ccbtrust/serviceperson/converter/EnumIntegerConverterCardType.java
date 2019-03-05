package com.ccbtrust.serviceperson.converter;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import org.jooq.impl.EnumConverter;

/**
 * 将整型转换为personCardType枚举型
 * @author nzhang
 */
public class EnumIntegerConverterCardType extends EnumConverter {
    private static final long serialVersionUID = 8170289733029543438L;

    public EnumIntegerConverterCardType() {
        super(Integer.class, PersonCardType.class);
    }
}
