package com.bookcollection.bookcollection.repository;

import com.bookcollection.bookcollection.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    long countByItemId (long itemId);
    boolean existsByItemIdAndUserId(Long itemId, Long userId);
    // Añade estos métodos para evitar el error
    List<Like> findByItemId(Long itemId);
    List<Like> findByUserId(Long userId);
}
