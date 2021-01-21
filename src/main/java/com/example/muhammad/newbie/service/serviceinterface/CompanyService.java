package com.example.muhammad.newbie.service.serviceinterface;

import com.example.muhammad.newbie.model.Company;

public interface CompanyService {
    Object addCompany(Company company);
    Object updateCompany(Company company, long id);
}
