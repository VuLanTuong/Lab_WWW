package com.example.week6_vulantuong.controller;

import com.example.week6_vulantuong.models.Post;
import com.example.week6_vulantuong.models.PostComment;
import com.example.week6_vulantuong.models.User;
import com.example.week6_vulantuong.repositories.UserRepository;
import com.example.week6_vulantuong.services.PostCommentService;
import com.example.week6_vulantuong.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository userService;

    @Autowired
    private PostServices postServices;

    @Autowired
    private PostCommentService postCommentService;

    private String emailTemp;
    @GetMapping("/")
    public String login(){
//
//        List<Candidate> list = candidateService.suggestCandidate(1L);
//
//        log.info("{}", list);

        return "login";
    }

    @PostMapping("/")
    public String getHome(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          Model model,
                          RedirectAttributes redirectAttributes){


        Optional<User> user = userService.findByEmailAndPasswordHash(email, password);

        User user1 = new User();
        if(user.isPresent()){
           user1 = user.get();
            emailTemp = email;
//            redirectAttributes.addAttribute("email", email);
            return "redirect:/listPost";
        }

       return "login";
    }


    @GetMapping("/listPost")
    public String listPost(Model model){

        List<Post> posts = postServices.getAll();
        model.addAttribute("posts", posts);

        for(Post post : posts){
            Set<PostComment> postComments = postCommentService.findByPost(post);
            post.setPostComments(postComments);
            postServices.insertPost(post);
        }


        return "listPost";
    }

    @PostMapping("/save")
    public String insertPost(@RequestParam("postContent") String postContent,
                             @RequestParam("title") String title,
                             @RequestParam("summary") String summary){
        Optional<User> optionalUser = userService.findByEmail(emailTemp);
        User author = new User();
        if(optionalUser.isPresent()){
             author = optionalUser.get();
        }

        Post post = new Post();
        post.setAuthor(author);
        post.setContent(postContent);
        post.setMetaTitle(title);
        post.setPublished(true);
        post.setSummary(summary);
        post.setCreatedAt(Instant.now());
        post.setPublishedAt(Instant.now());
        post.setUpdatedAt(Instant.now());


        postServices.insertPost(post);

        System.out.println("OKKKKKKKKKK");


        return "listPost";
    }


    @PostMapping("/submit")
    public String insertComment(@RequestParam("content") String content,
                             @RequestParam("title") String title,
                                @RequestParam("postId") long postId){
        Optional<User> optionalUser = userService.findByEmail(emailTemp);
        User author = new User();
        if(optionalUser.isPresent()){
            author = optionalUser.get();
        }

        Optional<Post> optionalPost = postServices.findById(postId);

        PostComment postComment = new PostComment();

        postComment.setTitle(title);
        postComment.setContent(content);
        postComment.setUser(author);
        postComment.setPublished(true);
        postComment.setCreatedAt(Instant.now());
        postComment.setPublishedAt(Instant.now());

        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            postComment.setPost(post);
            postCommentService.insert(postComment);
            System.out.println("OKKKKKKKKKK");
            return "redirect:listPost";
        }
        return "listPost";
    }


}
