package com.example.gk3.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String fullName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

}
