package com.example.muhammad.newbie.service.serviceinterface;

import com.example.muhammad.newbie.model.Job;

import java.util.List;

public interface JobService {
    List<Job> getCompanyJobList(long companyId);
    Object createJob(long companyId, Job job);
}
