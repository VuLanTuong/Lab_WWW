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
    private Roles roles;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

}
