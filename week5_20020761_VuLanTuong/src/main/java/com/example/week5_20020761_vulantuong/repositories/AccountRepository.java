package com.example.week5_20020761_vulantuong.repositories;

import com.example.week5_20020761_vulantuong.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsernameAndPassword(String username, String password);
}
