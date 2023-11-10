package com.example.week6_vulantuong.repositories;

import com.example.week6_vulantuong.models.Post;
import com.example.week6_vulantuong.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

    Set<PostComment> findByPost(Post post);

}
