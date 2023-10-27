package com.example.gk3.models;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Roles role;
    private String companyName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }

    public Experience(long id, LocalDate fromDate, String description, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.id = id;
        this.fromDate = fromDate;
        this.description = description;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    public Experience(LocalDate fromDate, String description, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.fromDate = fromDate;
        this.description = description;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Roles getRole() {
        return role;
    }

    public void setRoles(Roles role) {
        this.role= role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", companyName='" + companyName + '\'' +

                '}';
    }
}
