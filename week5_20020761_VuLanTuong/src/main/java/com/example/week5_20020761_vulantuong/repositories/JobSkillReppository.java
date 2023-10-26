package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillReppository extends JpaRepository<JobSkill, Long> {

}
