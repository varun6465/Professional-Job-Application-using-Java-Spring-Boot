package com.example.firstjob.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface jobservice {
    List<job> findall();
    void  createjob(job job);

    job getjobbyid(Long id);

    boolean deletejobbyid(Long id);

    //boolean updatedjob(Long id, ResponseEntity<String> updatejob);

    boolean updatejob(Long id, job updatedjob);
}
