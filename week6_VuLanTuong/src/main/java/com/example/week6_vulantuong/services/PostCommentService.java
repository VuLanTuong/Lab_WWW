package com.example.week6_vulantuong.services;

import com.example.week6_vulantuong.models.Post;
import com.example.week6_vulantuong.models.PostComment;
import com.example.week6_vulantuong.repositories.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public Set<PostComment> findByPost(Post post){
        return postCommentRepository.findByPost(post);
    }

    public PostComment insert(PostComment postComment){
        return postCommentRepository.save(postComment);
    }
}
