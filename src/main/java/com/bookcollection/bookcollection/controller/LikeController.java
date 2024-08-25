package com.bookcollection.bookcollection.controller;

import com.bookcollection.bookcollection.entity.Like;
import com.bookcollection.bookcollection.service.like.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long id) {
        Optional<Like> like = likeService.getLikeById(id);
        return like.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like createdLike = likeService.createLike(like);
        return new ResponseEntity<>(createdLike, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<Like>> getLikesByItemId(@PathVariable Long itemId) {
        List<Like> likes = likeService.getLikesByItemId(itemId);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Like>> getLikesByUserId(@PathVariable Long userId) {
        List<Like> likes = likeService.getLikesByUserId(userId);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/count/item/{itemId}")
    public ResponseEntity<Long> countLikesByItemId(@PathVariable Long itemId) {
        long count = likeService.countLikesByItemId(itemId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsLike(@RequestParam Long itemId, @RequestParam Long userId) {
        boolean exists = likeService.existsLike(itemId, userId);
        return ResponseEntity.ok(exists);
    }
}
