package com.example.demo.service;

import com.example.demo.dto.CreatePostRequest;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PostService {

    private final PostRepository pRepo;

    public Post createPost(CreatePostRequest req){
        Post post = new Post();
        post.setAuthorId(req.getAuthorId());
        post.setAuthorType(req.getAuthorType());
        post.setContent(req.getContent());

        return pRepo.save(post);
    }
}
