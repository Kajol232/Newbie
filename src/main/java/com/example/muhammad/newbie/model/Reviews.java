package com.example.muhammad.newbie.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Reviews {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reviewMessage;
    @ManyToOne
    private Users usersReviewed;
    @ManyToOne
    private Users usersReviewing;
    @ManyToOne
    private Job job;

    protected Reviews() {
    }

    public Reviews(String reviewMessage, Users usersReviewed, Users usersReviewing, Job job) {
        this.reviewMessage = reviewMessage;
        this.usersReviewed = usersReviewed;
        this.usersReviewing = usersReviewing;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public Users getUserReviewed() {
        return usersReviewed;
    }

    public void setUserReviewed(Users usersReviewed) {
        this.usersReviewed = usersReviewed;
    }

    public Users getUserReviewing() {
        return usersReviewing;
    }

    public void setUserReviewing(Users usersReviewing) {
        this.usersReviewing = usersReviewing;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
