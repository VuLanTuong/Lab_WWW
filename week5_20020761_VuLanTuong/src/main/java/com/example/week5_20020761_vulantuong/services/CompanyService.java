package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.models.Company;
import com.example.week5_20020761_vulantuong.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService  {
    @Autowired
    private CompanyRepository companyRepository;
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public Company findByName(String name){
        return companyRepository.findByCompName(name);
    }

    public Optional<Company> findById(long id){
        return companyRepository.findById(id);
    }



}
