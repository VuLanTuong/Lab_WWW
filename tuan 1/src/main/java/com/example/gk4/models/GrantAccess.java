package com.example.gk4.models;

import com.example.gk4.convert.IsGrantConverter;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Convert(converter = IsGrantConverter.class)
    private IsGrant isGrant;
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, IsGrant isGrant, String note) {
        this.role = role;
        this.account = account;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public IsGrant getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(IsGrant isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrantAccess)) return false;
        GrantAccess that = (GrantAccess) o;
        return Objects.equals(getRole(), that.getRole()) && Objects.equals(getAccount(), that.getAccount()) && getIsGrant() == that.getIsGrant() && Objects.equals(getNote(), that.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole(), getAccount());
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
