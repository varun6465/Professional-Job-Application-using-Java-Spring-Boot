package com.example.firstjob.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface jobrepository extends JpaRepository<job, Long> {
}
