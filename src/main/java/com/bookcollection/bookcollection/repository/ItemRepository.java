package com.bookcollection.bookcollection.repository;

import com.bookcollection.bookcollection.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCollectionId(Long collectionId);

}
