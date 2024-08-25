package com.bookcollection.bookcollection.repository;

import com.bookcollection.bookcollection.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<UserComment, Long> {
    List<UserComment> findByItemId(Long itemId);
}
