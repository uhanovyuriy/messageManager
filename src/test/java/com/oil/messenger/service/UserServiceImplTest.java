package com.oil.messenger.service;

import com.oil.messenger.TestDataUser;
import com.oil.messenger.model.User;
import org.junit.Assert;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "com.oil.messenger.repository")
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl service;

    @Test
    public void testCreate() {
        User actual = new User(TestDataUser.USER_3);
        actual.setId(TestDataUser.ID_3);
        User expected = service.create(TestDataUser.USER_3);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getCompany().getId(), actual.getCompany().getId());
        expected.setCompany(TestDataUser.getCompanyWithId2());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate() {
        User actual = new User(TestDataUser.USER_1);
        actual.setId(TestDataUser.ID_1);
        actual.setName("new");
        service.update(actual, actual.getId());
        User expected = service.findById(actual.getId());
        Assert.assertNotNull(expected);
        expected.setCompany(TestDataUser.getCompanyWithId1());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        service.delete(TestDataUser.ID_1);
        List<User> actual = Collections.singletonList(service.findById(TestDataUser.ID_2));
        List<User> expected = service.getAll();
        Assert.assertNotNull(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testFindByEmail() {
        User actual = new User(TestDataUser.USER_2);
        actual.setId(TestDataUser.ID_2);
        User expected = service.findByEmail(TestDataUser.EMAIL_2);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getCompany().getId(), actual.getCompany().getId());
        expected.setCompany(TestDataUser.getCompanyWithId1());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        User actual = new User(TestDataUser.USER_1);
        actual.setId(TestDataUser.ID_1);
        User expected = service.findById(TestDataUser.ID_1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getCompany().getId(), actual.getCompany().getId());
        expected.setCompany(TestDataUser.getCompanyWithId1());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAll() {
        List<User> actual = TestDataUser.getUsers();
        List<User> expected = service.getAll();
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.get(0).getCompany().getId(), actual.get(0).getCompany().getId());
        expected.get(0).setCompany(TestDataUser.getCompanyWithId1());
        Assert.assertEquals(expected.get(1).getCompany().getId(), actual.get(1).getCompany().getId());
        expected.get(1).setCompany(TestDataUser.getCompanyWithId1());
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}