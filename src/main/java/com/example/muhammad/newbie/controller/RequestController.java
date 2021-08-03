package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Request;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.User;
import com.example.muhammad.newbie.repository.RequestRepository;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping(value = "/requests")
public class RequestController {
    @Autowired
    private RequestServiceImpl requestService;
    @Autowired
    private RequestRepository requestRepository;
    private Response response = new Response();

    @GetMapping(path = "/lists")
    public List<Request> getRequestList(){
        return (List<Request>) requestRepository.findAll();
    }
    @GetMapping(path = "/getUserDetails/{id}")
    public User getUserDetails(@PathVariable("id") long id){
        return (User) requestService.getUserDetails(id);
    }
    @GetMapping(path = "/getCompanyDetails/{id}")
    public Company getCompanyDetails(@PathVariable("id") long id){
        return (Company) requestService.getCompanyDetails(id);
    }
    @PostMapping(path = "/approve/{id}")
    public Object approveRequest(@PathVariable("id") long id){
        return requestService.approveRequest(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Object deleteRequest(@PathVariable("id") long id){
        Request r = requestRepository.findById(id).get();
        requestRepository.delete(r);
        response.setStatus("00");
        response.setMessage("Request rejected");
        return response;
    }
}
