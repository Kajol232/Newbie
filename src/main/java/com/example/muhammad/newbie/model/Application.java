package com.example.muhammad.newbie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Application {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Job job;
    private String status;

    protected Application() {
    }

    public Application(Users users, Job job, String status) {
        this.users = users;
        this.job = job;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
