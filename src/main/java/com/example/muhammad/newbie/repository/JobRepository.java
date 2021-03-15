package com.example.muhammad.newbie.repository;

import com.example.muhammad.newbie.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findByCompany(long id);
}
