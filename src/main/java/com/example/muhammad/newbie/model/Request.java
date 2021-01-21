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
    private Users users;
    @OneToOne
    private Company company;

    protected Request() {
    }

    public Request(String requestType, Users user) {
        this.requestType = requestType;
        this.users = user;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
