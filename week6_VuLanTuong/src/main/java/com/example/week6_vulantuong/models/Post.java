package com.example.week6_vulantuong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor @Setter @Getter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean published;
    @Lob
    private String content;
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<PostComment> postComments;

    @ManyToOne
    @JoinColumn(name = "parentId", nullable = true)
    private Post parent;

    @Column(name = "metaTitle",length = 100)
    private String metaTitle;
    private String summary;
    @Column(name = "createdAt")
    private Instant createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;


    @Column(length = 75)
    private String title;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;
    @Column(name = "updatedAt")
    private Instant updatedAt;
    @Column(name = "publishedAt")
    private Instant publishedAt;


    public Post(Boolean published, String content, Set<PostComment> postComments, Post parent, String metaTitle, String summary, Instant createdAt, Set<Post> posts, String title, User author, Instant updatedAt, Instant publishedAt) {
        this.published = published;
        this.content = content;
        this.postComments = postComments;
        this.parent = parent;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.posts = posts;
        this.title = title;
        this.author = author;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", published=" + published +
                ", content='" + content + '\'' +
                ", postComments=" + postComments +
                ", parent=" + parent +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", createdAt=" + createdAt +
                ", posts=" + posts +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", updatedAt=" + updatedAt +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
