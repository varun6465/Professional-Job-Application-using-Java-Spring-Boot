package com.example.firstjob.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reviewrepository extends JpaRepository<review, Long> {
    List<review> findByCompanyId(Long companyid);
}
