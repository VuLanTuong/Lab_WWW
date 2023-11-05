package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long candidateId;
    private Date dob;
    private String email;
    private String fullName;
    private String phone;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;


    public Candidate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate candidate)) return false;
        return candidateId == candidate.candidateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId);
    }
}