package com.example.week6_vulantuong.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;


@Entity
@Table(name = "post_comment")
@NoArgsConstructor
@AllArgsConstructor @Setter @Getter
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment parent;
    @Transient
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean published;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @Column(name = "createdAt")
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @Override
    public String toString() {
        return "Comment{" +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", content='" + content + '\'' +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", user=" + user.getFirstName() +
                '}';
    }
}
