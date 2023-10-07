package models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
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

    public Job() {
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
}
