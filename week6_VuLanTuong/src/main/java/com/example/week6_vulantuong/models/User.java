package com.example.week6_vulantuong.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    private String mobile;
    @Column(name = "lastLogin")
    private Instant lastLogin;
    @Column(length = 50, name = "lastName")
    private String lastName;
    @Column(columnDefinition = "TINYTEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String profile;
    @Column(name = "registeredAt")
    private Instant registeredAt;
    @Column(length = 32, name = "passwordHash")
    private String passwordHash;
    @Column(length = 50, name = "middleName")
    private String middleName;
    @Column(length = 50, name = "firstName")
    private String firstName;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> postComments;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
}

