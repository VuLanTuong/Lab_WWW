package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table @Setter @Getter @ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToOne()
    @JoinColumn(name = "can_id", nullable = true)
    private Candidate candidate;

    @OneToOne()
    @JoinColumn(name = "com_id", nullable = true)
    private Company company;

    public Account() {
    }

    public Account(String username, String password, Candidate candidate) {
        this.username = username;
        this.password = password;
        this.candidate = candidate;
    }


}

