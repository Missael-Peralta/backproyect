package com.bookcollection.bookcollection.service.comments;

import com.bookcollection.bookcollection.entity.UserComment;
import com.bookcollection.bookcollection.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplements implements CommentService  {


    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImplements(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<UserComment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<UserComment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public UserComment createComment(UserComment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public UserComment updateComment(Long id, UserComment comment) {
        Optional<UserComment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            UserComment updatedComment = existingComment.get();
            updatedComment.setMessage(comment.getMessage());
            updatedComment.setItem(comment.getItem());
            updatedComment.setUser(comment.getUser());
            return commentRepository.save(updatedComment);
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<UserComment> getCommentsByItemId(Long itemId) {
        return commentRepository.findByItemId(itemId);
    }
}
