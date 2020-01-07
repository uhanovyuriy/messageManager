package com.oil.messenger.service;

import com.oil.messenger.TestDataCompany;
import com.oil.messenger.model.Company;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "com.oil.messenger.repository")
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CompanyServiceImplTest {

    @Autowired
    CompanyServiceImpl service;

    @Test
    public void testCreate() {
        Company created = service.create(TestDataCompany.COMPANY_3);
        List<Company> expected = service.getAll();
        List<Company> actual = new ArrayList<>(TestDataCompany.getCompanies());
        actual.add(created);
        Assert.assertNotNull(created);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testFindByEmail() {
        Company actual = TestDataCompany.COMPANY_1;
        actual.setId(TestDataCompany.ID_1);
        Company expected = service.findByEmail(TestDataCompany.EMAIL_1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        Company expected = service.findById(TestDataCompany.ID_2);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), TestDataCompany.ID_2);
    }

    @Test
    public void testGetAll() {
        List<Company> expected = service.getAll();
        List<Company> actual = TestDataCompany.getCompanies();
        Assert.assertNotNull(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testUpdate() {
        Company actual = new Company(TestDataCompany.COMPANY_2);
        actual.setId(TestDataCompany.ID_2);
        actual.setAddress(TestDataCompany.ADDRESS_3);
        service.update(actual, actual.getId());
        Company expected = service.findByEmail(TestDataCompany.EMAIL_2);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testDelete() {
        Company company = new Company(TestDataCompany.COMPANY_1);
        company.setId(TestDataCompany.ID_1);
        service.delete(TestDataCompany.ID_1);
        List<Company> expected = service.getAll();
        List<Company> actual = service.getAll();
        actual.remove(company);
        Assert.assertNotNull(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}