package com.example.firstjob.review.impl;
import com.example.firstjob.company.company;
import com.example.firstjob.review.review;
import com.example.firstjob.review.reviewservice;
import com.example.firstjob.review.reviewrepository;
import org.springframework.stereotype.Service;
import com.example.firstjob.company.companyservice;

import java.util.List;
@Service
public class reviewserviceimpl implements reviewservice {
    private final reviewrepository reviewrepository;
    private companyservice companyservice;

    public reviewserviceimpl(com.example.firstjob.review.reviewrepository reviewrepository, companyservice companyservice) {
        this.reviewrepository = reviewrepository;
        this.companyservice = companyservice;
    }

   /* @Override
    public List<review> getallreviews() {
        return reviewrepository.findAll();
    }*/

    @Override
    public List<review> getallreviews(Long companyid) {
        List<review> reviews = reviewrepository.findByCompanyId(companyid);
        return reviews;
    }

    @Override
    public boolean addreview(Long companyid, review review) {
        company company = companyservice.getcompanybyid(companyid);
        if(company!= null){
            review.setCompany(company);
            reviewrepository.save(review);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public review getreview(Long companyid, Long reviewid) {
        List<review> reviews = reviewrepository.findByCompanyId(companyid);
        return reviews.stream()
                .filter(review ->  review.getId().equals(reviewid))
                .findFirst()
                .orElse(null);
        //return null;
    }

    @Override
    public boolean updatereview(Long companyid, Long reviewid, review updatedreview) {
      if(companyservice.getcompanybyid(companyid)!=null){
          updatedreview.setCompany(companyservice.getcompanybyid(companyid));
          updatedreview.setId(reviewid);
          reviewrepository.save(updatedreview);
          return true;
      }else{
        return false;
    }}

    @Override
    public boolean deletereview(Long companyid, Long reviewid) {
        if(companyservice.getcompanybyid(companyid)!=null && reviewrepository.existsById(reviewid)){
            review review = reviewrepository.findById(reviewid).orElse(null);
            company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyservice.updatecompany(company, companyid);
            reviewrepository.deleteById(reviewid);
            return true;
        }else {
            return false;
        }
    }
}
