package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.dao.RegisterUser;
import com.example.muhammad.newbie.repository.CompanyRepository;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.CompanyServiceImpl;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private Response response = new Response();

    @GetMapping(path = "/getCompanyList")
    public List<Company> getCompanyList(){
        return (List<Company>) companyRepository.findAll();
    }

    @GetMapping(path = "/getCompanyById/{id}")
    public Company getCompanyById(@PathVariable("id") long id){
        return companyRepository.findById(id).get();
    }

    @PostMapping(path = "/addCompany", consumes = "application/json", produces = "application/json")
    public Object addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @PostMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    public Object updateCompany(@RequestBody Company company, @PathVariable("id") long id){
        return companyService.updateCompany(company, id);
    }

    @PostMapping(path = "/addRecruiters", consumes = "application/json",produces = "application/json")
    public Object addRecruiters(@RequestBody RegisterUser registerUser, @RequestParam ("image") MultipartFile multipartFile) throws IOException, ParseException {
        String roleName = "RECRUITERS";
        return userDetailsService.addUser(registerUser, roleName, multipartFile);
    }

    @PostMapping(path = "/addCompanyAdmins", consumes = "application/json",produces = "application/json")
    public Object addCompanyAdmins(@RequestBody RegisterUser registerUser, @RequestParam ("image") MultipartFile multipartFile) throws IOException, ParseException {
        String roleName = "COMPANY-ADMIN";
        return userDetailsService.addUser(registerUser, roleName, multipartFile);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Object deleteCompany(@PathVariable("id") long id){
        Company company = companyRepository.findById(id).get();
        companyRepository.delete(company);
        response.setStatus("00");
        response.setMessage("Company deleted successfully");
        return response;
    }
}
