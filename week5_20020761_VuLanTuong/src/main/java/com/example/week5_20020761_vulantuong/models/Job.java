package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table
@Setter @Getter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long jobId;
    private String jobDescription;
    private String jobName;

    @OneToOne
    @JoinColumn(name = "com_id")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<JobSkill> skills;

    public Job() {
    }


    public Job(String jobDescription, String jobName, Company company, List<JobSkill> skills) {
        this.jobDescription = jobDescription;
        this.jobName = jobName;
        this.company = company;
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return jobId == job.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobName='" + jobName + '\'' +
                ", company=" + company +
                ", skills=" + skills +
                '}';
    }
}
