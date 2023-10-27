package com.example.tuan1.services;

import com.example.tuan1.models.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    boolean insertAccount(Account account) throws Exception;
    Account findByUsernameAndPassword(String username, String password) throws SQLException;
    boolean checkRoleAdmin(Account account) throws SQLException;

    List<Account> getAllAccount() throws SQLException;

}
