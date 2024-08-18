package com.example.firstjob.review;

import com.example.firstjob.job.job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.example.firstjob.company.company;

import java.util.List;

//public class review package com.example.firstjob.company;

        //import com.example.firstjob.job.job;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import jakarta.persistence.*;

        import java.util.List;

@Entity
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private double rating;
    @JsonIgnore

    @ManyToOne
    private company company;

    public com.example.firstjob.company.company getCompany() {
        return company;
    }

    public void setCompany(com.example.firstjob.company.company company) {
        this.company = company;
    }
    //private List<review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public List<job> getJobs() {
        return jobs;
    }

    public void setJobs(List<job> jobs) {
        this.jobs = jobs;
    }*/

    public review() {
    }
}
