package com.example.demo.service;

import com.example.demo.dto.CreateCommentRequest;
import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository cRepo;

    public Comment addComment(
            Long postId,
            CreateCommentRequest req
    ){
        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setAuthorId(req.getAuthorId());
        comment.setAuthorType(req.getAuthorType());
        comment.setContent(req.getContent());
        comment.setDepthLevel(req.getDepthLevel());

        return cRepo.save(comment);
    }

    public void likePost(Long postId, Long userId){

    }
}
