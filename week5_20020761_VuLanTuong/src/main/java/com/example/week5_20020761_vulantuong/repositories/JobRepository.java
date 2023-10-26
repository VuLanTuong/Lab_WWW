package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.Job;
import com.example.week5_20020761_vulantuong.models.JobSkill;
import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {



    @Query("select j from Job j where j.jobId =  :id  ")
    Job findByJobId(long id);

    @Modifying
    @Query("update Job j set j.skills =: skills where j.jobId = : jobId")
    void updateJobBySkills(List<JobSkill> skills, long jobId);
}
