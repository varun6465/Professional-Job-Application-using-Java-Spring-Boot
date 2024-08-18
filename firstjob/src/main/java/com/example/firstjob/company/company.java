package com.example.firstjob.company;

import com.example.firstjob.job.job;
import com.example.firstjob.review.review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore

    @OneToMany(mappedBy = "company")
    private List<job> jobs;
    @OneToMany(mappedBy = "company")
    private List<review> reviews;

    public List<review> getReviews() {
        return reviews;
    }

    public void setReviews(List<review> reviews) {
        this.reviews = reviews;
    }
    //private List<review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<job> getJobs() {
        return jobs;
    }

    public void setJobs(List<job> jobs) {
        this.jobs = jobs;
    }

    public company() {
    }
}
