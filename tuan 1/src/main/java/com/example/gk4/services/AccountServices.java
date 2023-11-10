package com.example.gk4.services;

import com.example.gk4.models.Account;
import com.example.gk4.models.Role;
import com.example.gk4.repositories.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices() {
        accountRepository = new AccountRepository();
    }

    public Account isAccount(String fullName, String password){
        return accountRepository.isAccount(fullName, password);
    }

    public List<Account> getAllAccount(){
        return accountRepository.getAllAccount();
    }

    public Account findById(String id){
        return  accountRepository.findById(id);
    }

    public void update(Account account){
      accountRepository.update(account);
    }

    public void remove(Account account){
        accountRepository.remove(account);
    }

    public void insert(Account account) {
        accountRepository.insert(account);
    }

    public List<Account> findByRole(String role){
        return accountRepository.findByRole(role);
    }


}
