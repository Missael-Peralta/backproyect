package com.bookcollection.bookcollection.controller;

import com.bookcollection.bookcollection.entity.Collection;
import com.bookcollection.bookcollection.service.collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {
    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    // Endpoint para crear una nueva colección
    @PostMapping
    public ResponseEntity<Collection> createCollection(@RequestBody Collection collection) {
        Collection savedCollection = collectionService.save(collection);
        return new ResponseEntity<>(savedCollection, HttpStatus.CREATED);
    }

    // Endpoint para obtener una colección por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Collection> getCollectionById(@PathVariable Long id) {
        Optional<Collection> collection = collectionService.findById(id);
        return collection.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para obtener todas las colecciones
    @GetMapping
    public ResponseEntity<List<Collection>> getAllCollections() {
        List<Collection> collections = collectionService.findAll();
        return ResponseEntity.ok(collections);
    }

    // Endpoint para eliminar una colección por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable Long id) {
        collectionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para obtener todas las colecciones de un usuario específico
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Collection>> getCollectionsByUserId(@PathVariable Long userId) {
        List<Collection> collections = collectionService.findByUserId(userId);
        return ResponseEntity.ok(collections);
    }

}
