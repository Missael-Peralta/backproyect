package com.bookcollection.bookcollection.controller;

import com.bookcollection.bookcollection.entity.Item;
import com.bookcollection.bookcollection.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/collection/{collectionId}")
    public ResponseEntity<List<Item>> getItemsByCollectionId(@PathVariable Long collectionId) {
        List<Item> items = itemService.getItemsByCollectionId(collectionId);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
