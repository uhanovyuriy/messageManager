package com.oil.messenger;

import com.oil.messenger.model.Company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.oil.messenger.model.AbstractBaseEntity.START_SEQ;

public class TestDataCompany {

    public static final Integer ID_1 = START_SEQ;
    private static final String NAME_1 = "Company 1";
    public static final String EMAIL_1 = "company_1@gmail.com";
    private static final String PASSWORD_1 = "company_1_password";
    private static final LocalDateTime REGISTERED_1 = LocalDateTime.now();
    private static final boolean ENABLED_1 = true;
    private static final String ADDRESS_1 = "company_1_address";
    public static final Integer ID_2 = START_SEQ + 1;
    private static final String NAME_2 = "Company 2";
    public static final String EMAIL_2 = "company_2@gmail.com";
    private static final String PASSWORD_2 = "company_2_password";
    private static final LocalDateTime REGISTERED_2 = LocalDateTime.now();
    private static final boolean ENABLED_2 = true;
    private static final String ADDRESS_2 = "company_2_address";
    public static final Integer ID_3 = START_SEQ + 2;
    private static final String NAME_3 = "Company 3";
    private static final String EMAIL_3 = "company_3@gmail.com";
    private static final String PASSWORD_3 = "company_3_password";
    private static final LocalDateTime REGISTERED_3 = LocalDateTime.now();
    private static final boolean ENABLED_3 = true;
    public static final String ADDRESS_3 = "company_3_address";

    public static final Company COMPANY_1 = new Company(NAME_1, EMAIL_1, PASSWORD_1, REGISTERED_1, ENABLED_1, ADDRESS_1);
    public static final Company COMPANY_2 = new Company(NAME_2, EMAIL_2, PASSWORD_2, REGISTERED_2, ENABLED_2, ADDRESS_2);
    public static final Company COMPANY_3 = new Company(NAME_3, EMAIL_3, PASSWORD_3, REGISTERED_3, ENABLED_3, ADDRESS_3);

    public static List<Company> getCompanies() {
        final List<Company> list = new ArrayList<>();
        COMPANY_1.setId(ID_1);
        COMPANY_2.setId(ID_2);
        list.add(COMPANY_1);
        list.add(COMPANY_2);
        return list;
    }
}
