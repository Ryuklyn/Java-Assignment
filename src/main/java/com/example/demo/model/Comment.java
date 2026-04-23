package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "comments")
@Data
@NoArgsConstructor

public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "post_id")
    private Long postId;

    @Column (name = "author_id")
    private Long authorId;

    @Column (name = "authorType")
    private String authorType;

    private String content;

    @Column (name = "depth_level")
    private int depthLevel;

    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }


}
