package com.example.muhammad.newbie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Company {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String webUrl;
    private String description;
    private Date establishmentDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "company_users",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    private List<User> users;
    private boolean isApproved;

    protected Company() {
    }

    public Company(String name, String webUrl, String description, Date establishmentDate) {
        this.name = name;
        this.webUrl = webUrl;
        this.description = description;
        this.establishmentDate = establishmentDate;
    }

    public Company(String name, String webUrl, String description, Date establishmentDate, boolean isApproved) {
        this.name = name;
        this.webUrl = webUrl;
        this.description = description;
        this.establishmentDate = establishmentDate;
        this.isApproved = isApproved;
    }


    public Company(String name, String webUrl, String description, Date establishmentDate, List<User> users, boolean isApproved) {
        this.name = name;
        this.webUrl = webUrl;
        this.description = description;
        this.establishmentDate = establishmentDate;
        this.users = users;
        this.isApproved = isApproved;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
