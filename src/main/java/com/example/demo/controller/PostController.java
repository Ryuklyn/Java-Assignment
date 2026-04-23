package com.example.demo.controller;

import com.example.demo.dto.CreateCommentRequest;
import com.example.demo.dto.CreatePostRequest;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/api/posts")
@RequiredArgsConstructor

public class PostController {

    private final PostService poServ;
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostRequest req){
        Post saved = poServ.createPost(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<?> addComment(
            @PathVariable Long postId,
            @RequestBody CreateCommentRequest req
            ){
        try {
            Comment saved = commentService
                    .addComment(postId, req);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<String> likePost(
            @PathVariable Long postId,
            @RequestParam Long userId
    ){
        commentService.likePost(postId,userId);
        return ResponseEntity.ok("Liked");
    }



}
