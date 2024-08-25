package com.bookcollection.bookcollection.service.tag;

import com.bookcollection.bookcollection.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> getAllTags();
    Optional<Tag> getTagById(Long id);
    Tag createTag(Tag tag);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
}
