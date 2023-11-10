package com.example.week6_vulantuong.repositories;

import com.example.week6_vulantuong.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPasswordHash(String email, String password);

    Optional<User> findByEmail(String email);
}
