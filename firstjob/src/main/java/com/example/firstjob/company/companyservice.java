package com.example.firstjob.company;

import java.util.List;

public interface companyservice {
    List<company> getallcompanies();

    //List<company> getbyid();
    boolean updatecompany(company company, Long id);
    void createcompany(company company);
    boolean deletecompanybyid(Long id);
    //company getcompanybyid(Long id);

    //company getcompanyById(Long id);

    company getcompanybyid(Long id);
}
