package com.bookcollection.bookcollection.repository;

import com.bookcollection.bookcollection.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByNameTag(String name);
}
