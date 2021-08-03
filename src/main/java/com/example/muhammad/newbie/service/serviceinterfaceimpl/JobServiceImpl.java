package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Job;
import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.repository.CompanyRepository;
import com.example.muhammad.newbie.repository.JobRepository;
import com.example.muhammad.newbie.service.serviceinterface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    private Response response = new Response();
    @Override
    public List<Job> getCompanyJobList(long companyId) {
        return jobRepository.findByCompany(companyId);
    }

    @Override
    public Object createJob(long companyId, Job job) {
        Company company = companyRepository.findById(companyId).get();
        if(company.isApproved()) {
            Job j = new Job(job.getTitle(), job.getSkillSet(), company, job.getJobCriteria(), job.getJobDescription(),
                    job.getNumOfCandidatesRequired(), job.getStatus(), job.getRegistrationEndDate(), job.getRecruiter());
            jobRepository.save(j);
            response.setStatus("00");
            response.setMessage("Job posted successfully");
        }else{
            response.setStatus("05");
            response.setMessage("Company not approved for posting jobs");
        }
        return response;
    }
}
