package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor

public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "author_id")
    private Long authorId;

    @Column (name = "author_type")
    private String authorType;

    private String content;

    @Column (name = "createdAt")
    private LocalDateTime createdAt;

    public void prePersist(){
        this.createdAt=LocalDateTime.now();
    }

}
