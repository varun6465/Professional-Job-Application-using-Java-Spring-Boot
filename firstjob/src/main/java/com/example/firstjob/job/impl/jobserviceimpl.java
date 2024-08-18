package com.example.firstjob.job.impl;

import com.example.firstjob.job.job;
import com.example.firstjob.job.jobrepository;
import com.example.firstjob.job.jobservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jobserviceimpl implements jobservice {
    private final jobrepository jobrepository;
    private Long nextId = 1L;

    public jobserviceimpl(jobrepository jobrepository) {
        this.jobrepository = jobrepository;
    }

    @Override
    public List<job> findall() {
        return jobrepository.findAll();
    }

    @Override
    public void createjob(job job) {
        if (job.getId() == null) {
            job.setId(nextId);
            nextId++;
        }
        jobrepository.save(job);
    }

    @Override
    public job getjobbyid(Long id) {

        return jobrepository.findById(id).orElse(null);
    }

    @Override
    public boolean deletejobbyid(Long id) {
        try {
            jobrepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatejob(Long id, job updatedjob) {
        Optional<job> jobOptional = jobrepository.findById(id);
        if (jobOptional.isPresent()) {
            job job = jobOptional.get();
            job.setTitle(updatedjob.getTitle());
            job.setDescription(updatedjob.getDescription());
            job.setMinsalary(updatedjob.getMinsalary());
            job.setMaxsalary(updatedjob.getMaxsalary());
            job.setLocation(updatedjob.getLocation());
            jobrepository.save(job);
            return true;
        }
        return false;
    }
}
