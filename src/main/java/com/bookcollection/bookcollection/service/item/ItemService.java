package com.bookcollection.bookcollection.service.item;

import com.bookcollection.bookcollection.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item saveItem(Item item);

    Optional<Item> getItemById(Long id);

    List<Item> getAllItems();

    List<Item> getItemsByCollectionId(Long collectionId);

    void deleteItemById(Long id);
}
