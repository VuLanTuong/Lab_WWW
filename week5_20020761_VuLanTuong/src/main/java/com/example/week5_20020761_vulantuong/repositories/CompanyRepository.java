package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


    @Query("select com from Company com where com.compName = :comName ")
    Company findByCompName(String comName);





}
