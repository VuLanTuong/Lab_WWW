package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.models.Account;
import com.example.week5_20020761_vulantuong.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public Account findAccooutn(String username, String password){
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
