package com.example.muhammad.newbie.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Job {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "job_skillset",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skillset_id")
    )
    private List<Skill> skillSet;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    private String jobCriteria;
    private String jobDescription;
    private int numOfCandidatesRequired;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "job_reviews",
            joinColumns = @JoinColumn(name = "job_reviews"),
            inverseJoinColumns = @JoinColumn(name = "reviews_id")
    )
    private List<Reviews> reviews;
    @ManyToOne
    private Users recruiter;
    private String status;
    //use to set deadline
    private Date registrationEndDate;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="job_applicants",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    private List<Application> applicants;

    protected Job() {
    }

    public Job(String title, List<Skill> skillSet, Company company, String jobCriteria, String jobDescription,
               int numOfCandidatesRequired, String status, Date registrationEndDate, Users recruiter) {
        this.title = title;
        this.skillSet = skillSet;
        this.company = company;
        this.jobCriteria = jobCriteria;
        this.jobDescription = jobDescription;
        this.numOfCandidatesRequired = numOfCandidatesRequired;
        this.status = status;
        this.registrationEndDate = registrationEndDate;
        this.recruiter = recruiter;
    }

    public Job(String title, List<Skill> skillSet, String jobCriteria, String jobDescription, int numOfCandidatesRequired, List<Reviews> reviews, String status, Date registrationEndDate, List<Application> applicants) {
        this.title = title;
        this.skillSet = skillSet;
        this.jobCriteria = jobCriteria;
        this.jobDescription = jobDescription;
        this.numOfCandidatesRequired = numOfCandidatesRequired;
        this.reviews = reviews;
        this.status = status;
        this.registrationEndDate = registrationEndDate;
        this.applicants = applicants;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public String getJobCriteria() {
        return jobCriteria;
    }

    public void setJobCriteria(String jobCriteria) {
        this.jobCriteria = jobCriteria;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumOfCandidatesRequired() {
        return numOfCandidatesRequired;
    }

    public void setNumOfCandidatesRequired(int numOfCandidatesRequired) {
        this.numOfCandidatesRequired = numOfCandidatesRequired;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(Date registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Application> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Application> applicants) {
        this.applicants = applicants;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Users getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Users recruiter) {
        this.recruiter = recruiter;
    }
}
