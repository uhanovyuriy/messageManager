package com.oil.messenger.service;

import com.oil.messenger.model.Company;
import com.oil.messenger.repository.CompanyCrudRepository;
import com.oil.messenger.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyCrudRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyCrudRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Company create(Company company) {
        Assert.notNull(company, "company must not by null");
        return repository.save(company);
    }

    @Transactional
    @Override
    public void update(Company company) {
        Assert.notNull(company, "company must not by null");
        repository.save(company);
    }

    @Transactional
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Company findByEmail(String email) {
        Assert.notNull(email, "email must not by null");
        Optional<Company> optional = repository.findByEmail(email);
        return optional.orElseThrow(() -> new NotFoundException("Company with email - " + email + ", not found"));
    }


    @Override
    public Company findById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }
}
