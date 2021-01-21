package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Request;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.repository.CompanyRepository;
import com.example.muhammad.newbie.repository.RequestRepository;
import com.example.muhammad.newbie.service.serviceinterface.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private RequestRepository requestRepository;
    private Response response = new Response();
    @Override
    public Object addCompany(Company company) {
        Request request = new Request("CompanyRequest");
        company.setApproved(false);
        requestRepository.save(request);
        companyRepository.save(company);

        response.setStatus("00");
        response.setMessage("Created Successfully,Pending approval");

        return response;
    }

    @Override
    public Object updateCompany(Company company, long id) {
        Company c = companyRepository.findById(id).get();
        c.setDescription(company.getDescription());
        c.setWebUrl(company.getWebUrl());
        c.setName(company.getName());

        companyRepository.save(c);

        response.setStatus("00");
        response.setMessage("Updates successful");

        return response;
    }
}
