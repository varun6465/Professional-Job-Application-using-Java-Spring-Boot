package com.example.firstjob.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "jobs")

public class jobcontroller {
    private jobservice jobservice;

    public jobcontroller(com.example.firstjob.job.jobservice jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<job>> findall(){
        return ResponseEntity.ok(jobservice.findall());
    }
    @PostMapping
    public ResponseEntity<String> createjob(@RequestBody job job) {
        jobservice.createjob(job);
        return new ResponseEntity<>("job added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<job> getjobbyid(@PathVariable Long id){

        job job = jobservice.getjobbyid(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    //@DeleteMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletejobbyid(@PathVariable Long id){
        boolean deleted = jobservice.deletejobbyid(id);
        if (deleted)
            return  new ResponseEntity<>("job deleted succesfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatejob(@PathVariable Long id, @RequestBody job updatedjob){
        //ResponseEntity<String> updatejob = null;
        boolean updated = jobservice.updatejob(id, updatedjob);
        if (updated)
            return new ResponseEntity<>("job update success", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
