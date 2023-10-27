package com.example.tuan1.services.impl;


import com.example.tuan1.models.Account;
import com.example.tuan1.repositories.AccountRepository;
import com.example.tuan1.services.AccountService;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.List;

public class AccountImpl implements AccountService {


    private AccountRepository repository;

    public AccountImpl() throws Exception {
        this.repository = new AccountRepository();
    }

    @Override
    public boolean insertAccount(Account account) throws Exception {

        return repository.insert(account);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) throws SQLException {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean checkRoleAdmin(Account account) throws SQLException {
        return repository.checkRoleAdmin(account);
    }

    @Override
    public List<Account> getAllAccount() throws SQLException {
        return repository.getAllAccount();
    }
}
