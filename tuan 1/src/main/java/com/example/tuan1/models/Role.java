package com.example.tuan1.models;

public class Role {
    private String role_id;
    private String role_name;

    private String description;

    private Status status;

    public Role(){

    }

    public Role(String role_id, String role_name, String description, Status status) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.description = description;
        this.status = status;
    }

}
