package com.example.muhammad.newbie.model.dao;

import com.example.muhammad.newbie.model.Company;
import com.example.muhammad.newbie.model.Skill;
import com.example.muhammad.newbie.validator.ValidPassword;

import java.util.Date;
import java.util.List;

public class RegisterUser {
    private String name;
    private String email;
    @ValidPassword
    private String password;
    private String confirmPassword;
    private Date dob;
    private char gender;
    private String mobile;
    private boolean emailNotification;
    private List<Skill> skillList;
    private Company company;
    private String institution;

    public RegisterUser(String name, String email, String password, String confirmPassword, Date dob, char gender, String mobile, boolean emailNotification) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
    }

    public RegisterUser(String name, String email, String password, String confirmPassword, Date dob, char gender,
                        String mobile, boolean emailNotification, List<Skill> skillList, String institution) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
        this.skillList = skillList;
        this.institution = institution;
    }

    public RegisterUser(String name, String email, String password, String confirmPassword, Date dob, char gender, String mobile, boolean emailNotification, Company company) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.emailNotification = emailNotification;
        this.company = company;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public List<Skill> getSkillsetList() {
        return skillList;
    }

    public void setSkillsetList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
