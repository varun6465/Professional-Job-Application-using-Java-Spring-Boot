package com.example.firstjob.company.impl;

import com.example.firstjob.company.company;
import com.example.firstjob.company.companyservice;
import com.example.firstjob.company.companyrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyserviceimpl implements companyservice {
    private final companyrepository companyrepository;

    public companyserviceimpl(companyrepository companyrepository) {
        this.companyrepository = companyrepository;
    }

    @Override
    public List<company> getallcompanies() {
        return companyrepository.findAll();
    }

    @Override
    public boolean updatecompany(company company, Long id) {
        Optional<company> companyOptional = companyrepository.findById(id);
        if (companyOptional.isPresent()) {
            company companytoupdate = companyOptional.get();
            companytoupdate.setDescription(company.getDescription());
            companytoupdate.setName(company.getName());
            companytoupdate.setJobs(company.getJobs());

            companyrepository.save(companytoupdate);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void createcompany(company company) {
        companyrepository.save(company);
    }

    @Override
    public boolean deletecompanybyid(Long id) {
        //companyrepository.deleteById(id);
        if(companyrepository.existsById(id)){
            companyrepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }



    @Override
    public company getcompanybyid(Long id) {
        return companyrepository.findById(id).orElse(null);
    }




    /*@Override
    public List<company> getbyid(){
        return companyrepository.findById();
    }*/

}
