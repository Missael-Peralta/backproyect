package com.bookcollection.bookcollection.service.like;

import com.bookcollection.bookcollection.entity.Like;
import com.bookcollection.bookcollection.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImplements implements LikeService {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImplements(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<Like> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public List<Like> getLikesByItemId(Long itemId) {
        return likeRepository.findByItemId(itemId);
    }

    @Override
    public List<Like> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }

    // Agrega estos métodos a tu implementación
    @Override
    public long countLikesByItemId(Long itemId) {
        return likeRepository.countByItemId(itemId);
    }

    @Override
    public boolean existsLike(Long itemId, Long userId) {
        return likeRepository.existsByItemIdAndUserId(itemId, userId);
    }
}
