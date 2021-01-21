package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Request;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.Users;
import com.example.muhammad.newbie.repository.CompanyRepository;
import com.example.muhammad.newbie.repository.RequestRepository;
import com.example.muhammad.newbie.repository.UserRepository;
import com.example.muhammad.newbie.service.serviceinterface.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    private Response response = new Response();

    @Override
    public Object approveRequest(long id) {
        Request r = requestRepository.findById(id).get();
        String requestType = r.getRequestType();
        if (requestType == "StudentRequest"){
            Users user = r.getUsers();
            user.setApproved(true);
            userRepository.save(user);
        }else{
            Company c = r.getCompany();
            c.setApproved(true);
            companyRepository.save(c);
        }
        response.setStatus("00");
        response.setMessage("Approved Successfully");

        return response;
    }

    @Override
    public Object getUserDetails(long id) {
        Request r = requestRepository.findById(id).get();
        return r.getUsers();
    }

    @Override
    public Object getCompanyDetails(long id) {
        Request r = requestRepository.findById(id).get();
        return r.getCompany();
    }
}
