package com.oil.messenger.service;

import com.oil.messenger.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void update(User user, int id);

    void delete(int id);

    User findByEmail(String email);

    User findById(int id);

    List<User> getAll();
}
