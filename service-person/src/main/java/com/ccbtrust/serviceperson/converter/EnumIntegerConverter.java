package com.ccbtrust.serviceperson.converter;

import com.ccbtrust.remoteclient.enums.PersonStatus;
import org.jooq.impl.EnumConverter;

/**
 * 将整型转换为枚举型
 * @author nzhang
 */
public class EnumIntegerConverter extends EnumConverter {
    private static final long serialVersionUID = 2841326434065019331L;

    public EnumIntegerConverter() {
        super(Integer.class, PersonStatus.class);
    }
}
