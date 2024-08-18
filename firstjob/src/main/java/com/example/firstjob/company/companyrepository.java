package com.example.firstjob.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface companyrepository extends JpaRepository<company, Long> {
/*
    List<company> findById(Long id);
*/
}
