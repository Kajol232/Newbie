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
    private User userReviewed;
    @ManyToOne
    private User userReviewing;
    @ManyToOne
    private Job job;

    protected Reviews() {
    }

    public Reviews(String reviewMessage, User userReviewed, User userReviewing, Job job) {
        this.reviewMessage = reviewMessage;
        this.userReviewed = userReviewed;
        this.userReviewing = userReviewing;
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

    public User getUserReviewed() {
        return userReviewed;
    }

    public void setUserReviewed(User userReviewed) {
        this.userReviewed = userReviewed;
    }

    public User getUserReviewing() {
        return userReviewing;
    }

    public void setUserReviewing(User userReviewing) {
        this.userReviewing = userReviewing;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
