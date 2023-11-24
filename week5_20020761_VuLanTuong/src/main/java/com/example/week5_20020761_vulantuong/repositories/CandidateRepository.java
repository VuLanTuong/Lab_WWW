package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {



//    @Query(value = "SELECT * FROM candidate c WHERE " +
//            "c.can_id IN (SELECT distinct cs.can_id FROM job_skill js " +
//            "JOIN candidate_skill cs ON js.skill_id = cs.skill_id WHERE js.job_id IN " +
//            "(SELECT distinct j.job_id FROM job j WHERE js.job.company.compId  = :companyId) AND cs.skill_level = " +
//            "js.skill_level)", nativeQuery = true)


    //select * from candidate c join candidate_skill cs on c.can_id = cs.can_id
    //join job_skill js on cs.skill_id = js.skill_id
    //join job j on js.job_id = j.job_id
    //where j.com_id = 1;
    @Query("""
            select c from Candidate c join CandidateSkill  cs
            on cs.candidate = c
            join JobSkill  js on js.skill = cs.skill
            join Job j on j = js.job
             where js.job.company.compId = :companyId
""")
    List<Candidate> suggestCandidateHaveSkill(long companyId);

    public Candidate findByCandidateId(long id);

}
