package com.example.gk4.models;

import com.example.gk4.convert.StatusConverter;
import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Account {
    @Id
    @Column(name = "account_id")
    private String id;
    private String fullName;
    private String password;

    private String email;

    private String phone;


    @Convert(converter = StatusConverter.class)
    private Status status;


    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<GrantAccess> grantAccesses;

    @OneToMany(mappedBy = "account")
    private List<Log> log;

    public Account(){

    }

    public Account(String id, String fullName, String password, String email, String phone, Status status) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Account(String id, String fullName, String password, String email, String phone, Status status, List<GrantAccess> grantAccesses, List<Log> log) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.grantAccesses = grantAccesses;
        this.log = log;
    }

    public Account(String fullName, String password, String email, String phone, Status status) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Account(String fullName, String password, String email, String phone, Status status, List<GrantAccess> grantAccesses) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.grantAccesses = grantAccesses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public List<Log> getLog() {
        return log;
    }

    public void setLog(List<Log> log) {
        this.log = log;
    }


    public Account(String fullName, String password, String email, String phone, Status status, List<GrantAccess> grantAccesses, List<Log> log) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.grantAccesses = grantAccesses;
        this.log = log;
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
        return "Account{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
