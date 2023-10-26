package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Setter @Getter
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long compId;
    private String about;
    private String email;
    private String compName;
    private String phone;
    private String web_url;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;

    public Company() {
    }

}
