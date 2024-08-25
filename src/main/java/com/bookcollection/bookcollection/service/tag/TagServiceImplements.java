package com.bookcollection.bookcollection.service.tag;

import com.bookcollection.bookcollection.entity.Tag;
import com.bookcollection.bookcollection.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImplements implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Optional<Tag> existingTag = tagRepository.findById(id);
        if (existingTag.isPresent()) {
            Tag updatedTag = existingTag.get();
            updatedTag.setNameTag(tag.getNameTag());
            return tagRepository.save(updatedTag);
        } else {
            return null;
        }
    }
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
