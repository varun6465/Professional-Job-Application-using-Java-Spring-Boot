package com.example.firstjob.review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyid}")
public class reviewcontroller {
    private final reviewservice reviewservice;

    public reviewcontroller(com.example.firstjob.review.reviewservice reviewservice) {
        this.reviewservice = reviewservice;
    }

    @GetMapping("/review")
    public ResponseEntity<List<review>> getallreviews(@PathVariable Long companyid){
        return new ResponseEntity<>(reviewservice.getallreviews(companyid), HttpStatus.OK);
    }
    @PostMapping("/review")
    public ResponseEntity<String> addreview(@PathVariable Long companyid, @RequestBody review review){
        boolean isreviewsaved =reviewservice.addreview(companyid, review);
        if(isreviewsaved)
            return new ResponseEntity<>("review added success",HttpStatus.OK);
        else
            return new ResponseEntity<>("review not saved",HttpStatus.NOT_FOUND);

    }
    @GetMapping("/review/{reviewid}")
    public ResponseEntity<review> getreview(@PathVariable Long companyid, @PathVariable Long reviewid){
        return new ResponseEntity<>(reviewservice.getreview(companyid, reviewid),HttpStatus.OK);
    }

    @PutMapping("/review/{reviewid}")
    public ResponseEntity<String> updatereview(@PathVariable Long companyid,Long reviewid, @RequestBody review review){
        boolean isreviewupdated = reviewservice.updatereview(companyid, reviewid, review);
        if(isreviewupdated)
            return new ResponseEntity<>("review updated success",HttpStatus.OK);
        else
            return new ResponseEntity<>("review not updated", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/review/{reviewid}")
    public ResponseEntity<String> deletereview(@PathVariable Long companyid,@PathVariable Long reviewid){
        boolean isreviewdeleted = reviewservice.deletereview(companyid, reviewid);
        if(isreviewdeleted)
            return new ResponseEntity<>("review delete success",HttpStatus.OK);
        else
            return new ResponseEntity<>("review not deleted", HttpStatus.NOT_FOUND);
    }

}
