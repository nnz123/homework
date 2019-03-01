/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Homework;
import com.generator.Keys;
import com.generator.tables.records.PersonRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Person extends TableImpl<PersonRecord> {

    private static final long serialVersionUID = 149289577;

    /**
     * The reference instance of <code>homework.person</code>
     */
    public static final Person PERSON = new Person();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PersonRecord> getRecordType() {
        return PersonRecord.class;
    }

    /**
     * The column <code>homework.person.id</code>.
     */
    public final TableField<PersonRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>homework.person.person_name</code>. 员工姓名
     */
    public final TableField<PersonRecord, String> PERSON_NAME = createField("person_name", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "员工姓名");

    /**
     * The column <code>homework.person.card_type</code>. 员工证件类型0身份证1护照
     */
    public final TableField<PersonRecord, Integer> CARD_TYPE = createField("card_type", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "员工证件类型0身份证1护照");

    /**
     * The column <code>homework.person.card_num</code>. 证件号码
     */
    public final TableField<PersonRecord, String> CARD_NUM = createField("card_num", org.jooq.impl.SQLDataType.VARCHAR.length(18).nullable(false), this, "证件号码");

    /**
     * The column <code>homework.person.person_picture</code>. 员工头像
     */
    public final TableField<PersonRecord, String> PERSON_PICTURE = createField("person_picture", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "员工头像");

    /**
     * The column <code>homework.person.phone_num</code>. 员工电话
     */
    public final TableField<PersonRecord, String> PHONE_NUM = createField("phone_num", org.jooq.impl.SQLDataType.VARCHAR.length(15), this, "员工电话");

    /**
     * The column <code>homework.person.person_status</code>. 0在职，1 离职
     */
    public final TableField<PersonRecord, Integer> PERSON_STATUS = createField("person_status", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "0在职，1 离职");

    /**
     * The column <code>homework.person.create_person</code>. 员工信息创建人
     */
    public final TableField<PersonRecord, String> CREATE_PERSON = createField("create_person", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "员工信息创建人");

    /**
     * The column <code>homework.person.create_time</code>. 员工信息创建时间
     */
    public final TableField<PersonRecord, LocalDateTime> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "员工信息创建时间");

    /**
     * The column <code>homework.person.edit_person</code>. 员工信息修改人
     */
    public final TableField<PersonRecord, String> EDIT_PERSON = createField("edit_person", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "员工信息修改人");

    /**
     * The column <code>homework.person.edit_time</code>. 员工信息修改时间
     */
    public final TableField<PersonRecord, LocalDateTime> EDIT_TIME = createField("edit_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "员工信息修改时间");

    /**
     * The column <code>homework.person.delete_person</code>. 员工信息删除人
     */
    public final TableField<PersonRecord, String> DELETE_PERSON = createField("delete_person", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "员工信息删除人");

    /**
     * The column <code>homework.person.delete_time</code>. 员工信息删除时间
     */
    public final TableField<PersonRecord, LocalDateTime> DELETE_TIME = createField("delete_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "员工信息删除时间");

    /**
     * The column <code>homework.person.delete_flag</code>. 删除标记
     */
    public final TableField<PersonRecord, Integer> DELETE_FLAG = createField("delete_flag", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "删除标记");

    /**
     * Create a <code>homework.person</code> table reference
     */
    public Person() {
        this("person", null);
    }

    /**
     * Create an aliased <code>homework.person</code> table reference
     */
    public Person(String alias) {
        this(alias, PERSON);
    }

    private Person(String alias, Table<PersonRecord> aliased) {
        this(alias, aliased, null);
    }

    private Person(String alias, Table<PersonRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Homework.HOMEWORK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PersonRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PERSON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PersonRecord> getPrimaryKey() {
        return Keys.KEY_PERSON_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PersonRecord>> getKeys() {
        return Arrays.<UniqueKey<PersonRecord>>asList(Keys.KEY_PERSON_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person as(String alias) {
        return new Person(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Person rename(String name) {
        return new Person(name, null);
    }
}
