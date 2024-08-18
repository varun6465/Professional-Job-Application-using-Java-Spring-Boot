package com.example.firstjob.company;

import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companycontroller {
    private final companyservice companyservice;

    public companycontroller(companyservice companyservice) {
        this.companyservice = companyservice;
    }

    @GetMapping//("/companies")
    public ResponseEntity<List<company>> getallcompanies() {
        return new ResponseEntity<>(companyservice.getallcompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatecompany(@PathVariable Long id, @RequestBody company company) {
        companyservice.updatecompany(company, id);
        return new ResponseEntity<>("company updated success", HttpStatus.OK);
    }

    @PostMapping

    public ResponseEntity<String> addcompany(@RequestBody company company) {
        companyservice.createcompany(company);
        return new ResponseEntity<>("company added success", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable Long id) {
        boolean isdeleted = companyservice.deletecompanybyid(id);
        if (isdeleted) {
            return new ResponseEntity<>("company deleted success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company not found", HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<company> getCompanyById(@PathVariable Long id) {
        company company = companyservice.getcompanybyid(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
