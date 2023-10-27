package com.example.gk3.services;

import com.example.gk3.models.Candidate;
import com.example.gk3.models.Experience;
import com.example.gk3.models.Roles;
import com.example.gk3.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.List;

public class CandidateService {
    private CandidateRepository candidateRepository;

    public CandidateService() {
        candidateRepository = new CandidateRepository();
    }

    public void insertCan(Candidate candidate){
        candidateRepository.insertCan(candidate);
    }

    public List<Candidate> findAll(){
        return candidateRepository.findAll();
    }

    public Candidate findById(long id){
        return candidateRepository.findById(id);
    }

    public List<Candidate> findByRole(Roles roles){
        return candidateRepository.findByRole(roles);
    }

    public List<Candidate> findByEmail(){
        return candidateRepository.findByEmail();
    }

    public List<Candidate> findByDatye(LocalDate date){
        return candidateRepository.findByDate(date);
    }
}
