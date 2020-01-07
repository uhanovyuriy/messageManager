package com.oil.messenger.service;

import com.oil.messenger.model.Company;

import java.util.List;

public interface CompanyService {

    Company create(Company company);

    void update(Company company, int id);

    void delete(int id);

    Company findByEmail(String email);

    Company findById(int id);

    List<Company> getAll();
}
