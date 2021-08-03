package com.example.muhammad.newbie.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_account")
public class Users {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> roles;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Date dob;
    @NotNull
    private char gender;
    @NotNull
    private boolean isActive;
    @NotNull
    private String mobile;
    @NotNull
    private boolean emailNotification;
    @NotNull
    @Column(length = 64)
    private String imageUrl;
    @NotNull
    @CreationTimestamp
    private LocalDateTime regDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_skillset",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skillset_id")
    )
    private List<Skill> skill;
    @ManyToOne
    private Company company;
    private String title;
    private String institution;
    private boolean isApproved;



    public Users() {
    }

    //for all users
    public Users(List<UserRole> roles,String name, String email, String password, Date dob, char gender,
                 String mobile, boolean emailNotification, String imageUrl,String title) {
        this.roles = roles;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
        this.imageUrl = imageUrl;
        this.title =title;
    }
    //for students
    public Users(List<UserRole> roles, String name, String email, String password, Date dob, char gender, String mobile,
                 boolean emailNotification, String imageUrl, List<Skill> skill, String title, String institution, boolean isApproved) {
        this.roles = roles;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
        this.imageUrl = imageUrl;
        this.skill = skill;
        this.title = title;
        this.institution = institution;
        this.isApproved = isApproved;
    }
    //for recruiters
    public Users(List<UserRole> roles, String name, String email, String password, Date dob, char gender, String mobile,
                 boolean emailNotification, String imageUrl, Company company, String title) {
        this.roles = roles;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
        this.imageUrl = imageUrl;
        this.company = company;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }


    @Transient
    public String getImageUrl() {
        if(imageUrl == null ){
            return null;
        }
        return "C:\\Users\\user\\Documents\\newbie\\src\\main\\resources\\static\\userImages\\" + getId() + "\\" + imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public List<Skill> getSkillSet() {
        return skill;
    }

    public void setSkillSet(List<Skill> skillSet) {
        this.skill = skillSet;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
