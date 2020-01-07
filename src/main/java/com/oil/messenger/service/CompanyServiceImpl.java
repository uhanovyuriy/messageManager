package com.oil.messenger.service;

import com.oil.messenger.model.Company;
import com.oil.messenger.repository.CompanyCrudRepository;
import com.oil.messenger.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.oil.messenger.util.ValidationUtil.checkNotFoundWithId;

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
    public void update(Company company, int id) {
        Assert.notNull(company, "company must not by null");
        checkNotFoundWithId(repository.save(company), id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.deleteById(id), id);
    }

    @Override
    public Company findByEmail(String email) {
        Assert.notNull(email, "email must not by null");
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Company with email: " + email + ", not found"));
    }


    @Override
    public Company findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company with id: " + id + ", not found"));
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }
}
