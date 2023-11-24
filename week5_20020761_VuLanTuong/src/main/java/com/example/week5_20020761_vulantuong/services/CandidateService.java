package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.models.Candidate;
import com.example.week5_20020761_vulantuong.repositories.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> suggestCandidate(long companyId){
        return candidateRepository.suggestCandidateHaveSkill(companyId);
    }
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

  public Candidate findById(long id){
        return candidateRepository.findByCandidateId(id);
  }
}
