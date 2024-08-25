package com.bookcollection.bookcollection.controller;


import com.bookcollection.bookcollection.entity.UserComment;
import com.bookcollection.bookcollection.service.comments.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<UserComment>> getAllComments() {
        List<UserComment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserComment> getCommentById(@PathVariable Long id) {
        Optional<UserComment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserComment> createComment(@RequestBody UserComment comment) {
        UserComment savedComment = commentService.createComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserComment> updateComment(@PathVariable Long id, @RequestBody UserComment comment) {
        UserComment updatedComment = commentService.updateComment(id, comment);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<UserComment>> getCommentsByItemId(@PathVariable Long itemId) {
        List<UserComment> comments = commentService.getCommentsByItemId(itemId);
        return ResponseEntity.ok(comments);
    }
}
