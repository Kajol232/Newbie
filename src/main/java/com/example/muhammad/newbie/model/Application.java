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
    private User user;
    @ManyToOne
    private Job job;
    private String status;

    protected Application() {
    }

    public Application(User user, Job job, String status) {
        this.user = user;
        this.job = job;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
