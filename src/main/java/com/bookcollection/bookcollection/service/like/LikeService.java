package com.bookcollection.bookcollection.service.like;

import com.bookcollection.bookcollection.entity.Like;
import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> getAllLikes();
    Optional<Like> getLikeById(Long id);
    Like createLike(Like like);
    void deleteLike(Long id);
    List<Like> getLikesByItemId(Long itemId);
    List<Like> getLikesByUserId(Long userId);
    long countLikesByItemId(Long itemId);
    boolean existsLike(Long itemId, Long userId);
}
