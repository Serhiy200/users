/*
 * This file is generated by jOOQ.
 */
package com.example.test.jooq.public_.tables.records;


import com.example.test.jooq.public_.tables.Account;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record6<Integer, String, String, String, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.account.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.account.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.account.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.account.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.account.surname</code>.
     */
    public void setSurname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.account.surname</code>.
     */
    public String getSurname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.account.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.account.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.account.password</code>.
     */
    public void setPassword(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.account.password</code>.
     */
    public String getPassword() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.account.age</code>.
     */
    public void setAge(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.account.age</code>.
     */
    public Integer getAge() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Account.ACCOUNT.ID;
    }

    @Override
    public Field<String> field2() {
        return Account.ACCOUNT.NAME;
    }

    @Override
    public Field<String> field3() {
        return Account.ACCOUNT.SURNAME;
    }

    @Override
    public Field<String> field4() {
        return Account.ACCOUNT.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return Account.ACCOUNT.PASSWORD;
    }

    @Override
    public Field<Integer> field6() {
        return Account.ACCOUNT.AGE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getSurname();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getPassword();
    }

    @Override
    public Integer component6() {
        return getAge();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getSurname();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getPassword();
    }

    @Override
    public Integer value6() {
        return getAge();
    }

    @Override
    public AccountRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AccountRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public AccountRecord value3(String value) {
        setSurname(value);
        return this;
    }

    @Override
    public AccountRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AccountRecord value5(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public AccountRecord value6(Integer value) {
        setAge(value);
        return this;
    }

    @Override
    public AccountRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Integer id, String name, String surname, String email, String password, Integer age) {
        super(Account.ACCOUNT);

        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        setAge(age);
    }
}