package com.oil.messenger.service;

import com.oil.messenger.model.User;
import com.oil.messenger.repository.UserCrudRepository;
import com.oil.messenger.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.oil.messenger.util.UserUtil.prepareToSave;
import static com.oil.messenger.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserCrudRepository repository;

    @Autowired
    public UserServiceImpl(UserCrudRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not by null");
        return repository.save(prepareToSave(user, passwordEncoder));
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        Assert.notNull(user, "user must not by null");
        checkNotFoundWithId(repository.save(user), id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.deleteById(id), id);
    }

    @Override
    public User findByEmail(String email) {
        Assert.notNull(email, "email must not by null");
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email: " + email + ", not found"));
    }

    @Override
    public User findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User " + id + " not found"));
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
