package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Job;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.repository.JobRepository;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping(value = "/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobServiceImpl jobService;

    private Response response = new Response();

    @GetMapping(path = "/list")
    public List<Job> getJobList(){
        return (List<Job>) jobRepository.findAll();
    }
    @GetMapping(path = "/list/{id}")
    public List<Job> getCompanyJobList(@PathVariable("id") long id){
        return jobService.getCompanyJobList(id);
    }
    @GetMapping(path = "/getJobById/{id}")
    public Job getJobById(@PathVariable("id") long id){
        return jobRepository.findById(id).get();
    }
    @PostMapping(path = "/createJob/{id}")
    public Object createJob(@RequestBody Job job, @PathVariable("id") long companyId){
        return null;

    }
}
