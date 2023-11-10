package com.example.week6_vulantuong.repositories;

import com.example.week6_vulantuong.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
