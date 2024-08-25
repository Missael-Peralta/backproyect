package com.bookcollection.bookcollection.service.item;

import com.bookcollection.bookcollection.entity.Item;
import com.bookcollection.bookcollection.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplements implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImplements(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByCollectionId(Long collectionId) {
        return itemRepository.findByCollectionId(collectionId);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

}
