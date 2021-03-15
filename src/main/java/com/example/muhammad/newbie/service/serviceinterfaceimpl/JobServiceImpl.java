package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.Job;
import com.example.muhammad.newbie.repository.JobRepository;
import com.example.muhammad.newbie.service.serviceinterface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> getCompanyJobList(long companyId) {
        return jobRepository.findByCompany(companyId);
    }

    @Override
    public Object createJob(long companyId, Job job) {

        return null;
    }
}
