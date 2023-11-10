package com.example.week6_vulantuong.services;

import com.example.week6_vulantuong.models.Post;
import com.example.week6_vulantuong.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    private PostRepository postRepository;

    public void insertPost(Post post){
        postRepository.save(post);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public Optional<Post> findById(long id){
        return postRepository.findById(id);
    }

}
