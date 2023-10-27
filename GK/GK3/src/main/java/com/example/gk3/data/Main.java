package com.example.gk3.data;

import com.example.gk3.models.Candidate;
import com.example.gk3.models.Experience;
import com.example.gk3.models.Roles;
import com.example.gk3.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CandidateRepository candidateRepository = new CandidateRepository();
        Candidate candidate = new Candidate("Thai Cho Dien","0665412541","thaichodien2@gmail.com"
                ,null);
        Experience experience1 = new Experience(LocalDate.now(),"Lam viec o cong ty A", Roles.STAFF,"Cong ty A",LocalDate.now(),candidate);
        Experience experience2 = new Experience(LocalDate.now(),"Lam viec o cong ty B", Roles.STAFF,"Cong ty B",LocalDate.now(),candidate);
        Experience experience3 = new Experience(LocalDate.now(),"Lam viec o cong ty C", Roles.STAFF,"Cong ty C",LocalDate.now(),candidate);
        List<Experience> experiences = List.of(experience1,experience2,experience3);
        candidate.setExperiences(experiences);
        candidateRepository.insertCan(candidate);
        Candidate candidate2 = new Candidate("Thinh Cho Dien","0665412541","thinhchodien2@gmail.com"
                ,null);
        Experience experience4 = new Experience(LocalDate.now(),"Lam viec o cong ty AA", Roles.STAFF,"Cong ty A",LocalDate.now(),candidate2);
        Experience experience5 = new Experience(LocalDate.now(),"Lam viec o cong ty BB", Roles.MANAGER,"Cong ty B",LocalDate.now(),candidate2);
        Experience experience6 = new Experience(LocalDate.now(),"Lam viec o cong ty CC", Roles.ADMINSTRATION,"Cong ty C",LocalDate.now(),candidate2);
        List<Experience> experiences2 = List.of(experience4,experience5,experience6);
        candidate2.setExperiences(experiences2);
        candidateRepository.insertCan(candidate2);
        Candidate candidate3 = new Candidate("Tuong Cho Dien","0665412541",null
                ,null);
        Experience experience7 = new Experience(LocalDate.now(),"Lam viec o cong ty AAA", Roles.STAFF,"Cong ty A",LocalDate.now(),candidate3);
        Experience experience8 = new Experience(LocalDate.now(),"Lam viec o cong ty BBB", Roles.STAFF,"Cong ty B",LocalDate.now(),candidate3);
        Experience experience9 = new Experience(LocalDate.now(),"Lam viec o cong ty CCC", Roles.STAFF,"Cong ty C",LocalDate.now(),candidate3);
        List<Experience> experiences3 = List.of(experience7,experience8,experience9);
        candidate3.setExperiences(experiences3);
        candidateRepository.insertCan(candidate3);
    }
}
