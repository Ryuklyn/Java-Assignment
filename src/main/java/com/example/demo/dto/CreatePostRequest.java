package com.example.demo.dto;

import lombok.Data;

@Data

public class CreatePostRequest {
    private Long authorId;
    private String authorType;
    private String content;
}
