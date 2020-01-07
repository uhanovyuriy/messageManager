package com.oil.messenger;

import com.oil.messenger.model.Company;
import com.oil.messenger.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.oil.messenger.model.AbstractBaseEntity.START_SEQ;

public class TestDataUser {

    public static final Integer ID_1 = START_SEQ + 2;
    private static final String NAME_1 = "user_1";
    private static final String EMAIL_1 = "user_1@gmail.com";
    private static final String PASSWORD_1 = "user_1_password";
    private static final LocalDateTime REGISTERED_1 = LocalDateTime.now();
    private static final boolean ENABLED_1 = true;
    public static final Integer ID_2 = START_SEQ + 3;
    private static final String NAME_2 = "user_2";
    public static final String EMAIL_2 = "user_2@gmail.com";
    private static final String PASSWORD_2 = "user_2_password";
    private static final LocalDateTime REGISTERED_2 = LocalDateTime.now();
    private static final boolean ENABLED_2 = true;
    public static final Integer ID_3 = START_SEQ + 4;
    private static final String NAME_3 = "user_3";
    private static final String EMAIL_3 = "user_3@gmail.com";
    private static final String PASSWORD_3 = "user_3_password";
    private static final LocalDateTime REGISTERED_3 = LocalDateTime.now();
    private static final boolean ENABLED_3 = true;
    private static final Company COMPANY_WITH_ID_1 = new Company(TestDataCompany.COMPANY_1);
    private static final Company COMPANY_WITH_ID_2 = new Company(TestDataCompany.COMPANY_2);
    private static final Company COMPANY_WITH_ID_3 = new Company(TestDataCompany.COMPANY_3);

    public static final User USER_1 = new User(NAME_1, EMAIL_1, getCompanyWithId1(), PASSWORD_1, REGISTERED_1,
            ENABLED_1);
    public static final User USER_2 = new User(NAME_2, EMAIL_2, getCompanyWithId1(), PASSWORD_2, REGISTERED_2,
            ENABLED_2);
    public static final User USER_3 = new User(NAME_3, EMAIL_3, getCompanyWithId2(), PASSWORD_3, REGISTERED_3,
            ENABLED_3);

    public static Company getCompanyWithId1() {
        COMPANY_WITH_ID_1.setId(TestDataCompany.ID_1);
        return COMPANY_WITH_ID_1;
    }

    public static Company getCompanyWithId2() {
        COMPANY_WITH_ID_2.setId(TestDataCompany.ID_2);
        return COMPANY_WITH_ID_2;
    }

    public static Company getCompanyWithId3() {
        COMPANY_WITH_ID_3.setId(TestDataCompany.ID_3);
        return COMPANY_WITH_ID_3;
    }

    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();
        USER_1.setId(ID_1);
        USER_2.setId(ID_2);
        list.add(USER_1);
        list.add(USER_2);
        return list;
    }
}
