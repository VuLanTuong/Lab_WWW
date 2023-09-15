package com.example.tuan1.services;

import com.example.tuan1.models.Account;

import java.sql.SQLException;

public interface AccountService {
    boolean insertAccount(Account account) throws Exception;
    Account findByUsernameAndPassword(String username, String password) throws SQLException;
    boolean checkRoleAdmin(Account account) throws SQLException;

}
