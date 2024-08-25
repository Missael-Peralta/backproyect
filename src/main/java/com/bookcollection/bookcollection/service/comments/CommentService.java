package com.bookcollection.bookcollection.service.comments;

import com.bookcollection.bookcollection.entity.UserComment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<UserComment> getAllComments();
    Optional<UserComment> getCommentById(Long id);
   UserComment createComment(UserComment comment);
    UserComment updateComment(Long id, UserComment comment);
    void deleteComment(Long id);
    List<UserComment> getCommentsByItemId(Long itemId);
}
