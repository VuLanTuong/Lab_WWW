package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.Company;
import com.example.week5_20020761_vulantuong.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("select  skill from Skill skill where skill.skillName = :skillName")
    Skill findBySkillName(String skillName);

    @Query("SELECT s FROM Skill s JOIN" +
            " JobSkill  js" +
            " on js.skill = s WHERE s.skillId NOT IN" +
            " (SELECT cs.skill.skillId FROM CandidateSkill cs WHERE cs.candidate.candidateId = :candidateId) " +
            " group by s order by count(s) desc")
    List<Skill> suggestForCandidate(long candidateId);


}
