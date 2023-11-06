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

    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<GrantAccess> grantAccesses;

    public Role(){

    }

    public Role(String id, String name, String description, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

