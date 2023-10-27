package com.example.gk4.models;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

@Table
@Entity
public class Role {
    @Id
    @Column(name = "role_id")
    private String id;
    private String name;

    private String description;

    private Status status;

    @OneToMany(mappedBy = "role")
    private List<GrantAccess> grantAccesses;

    public Role(){

    }

    public Role(String id, String name, String description, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
