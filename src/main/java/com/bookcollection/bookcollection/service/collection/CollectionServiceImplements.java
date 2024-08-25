package com.bookcollection.bookcollection.service.collection;

import com.bookcollection.bookcollection.entity.Collection;
import com.bookcollection.bookcollection.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImplements implements CollectionService {

    private final CollectionRepository collectionRepository;
    @Autowired
    public CollectionServiceImplements(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public Optional<Collection> findById(Long id) {
        return collectionRepository.findById(id);
    }

    @Override
    public List<Collection> findAll() {
        return collectionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        collectionRepository.deleteById(id);
    }

    @Override
    public List<Collection> findByUserId(Long userId) {
        return collectionRepository.findByUserId(userId);
    }

}
