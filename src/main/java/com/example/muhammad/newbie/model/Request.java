package com.example.muhammad.newbie.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Request {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String requestType;
    @NotNull
    @CreationTimestamp
    private LocalDateTime regDate;
    @OneToOne
    private User user;
    @OneToOne
    private Company company;

    protected Request() {
    }

    public Request(String requestType, User user) {
        this.requestType = requestType;
        this.user = user;
    }

    public Request(String requestType, Company company) {
        this.requestType = requestType;
        this.company = company;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
