package com.example.gk4.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private LocalDate login_time;
    private LocalDate logout_time;
    private String notes;

    public Log() {
    }

    public Log(Account account, LocalDate login_time, LocalDate logout_time, String notes) {
        this.account = account;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getLogin_time() {
        return login_time;
    }

    public void setLogin_time(LocalDate login_time) {
        this.login_time = login_time;
    }

    public LocalDate getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(LocalDate logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account=" + account +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
