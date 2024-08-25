package com.bookcollection.bookcollection.service.collection;

import com.bookcollection.bookcollection.entity.Collection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CollectionService {

    // Método para guardar o actualizar una colección
    Collection save(Collection collection);

    // Método para encontrar una colección por su ID
    Optional<Collection> findById(Long id);

    // Método para obtener todas las colecciones
    List<Collection> findAll();

    // Método para eliminar una colección por su ID
    void deleteById(Long id);

    // Método para encontrar colecciones por ID de usuario
    List<Collection> findByUserId(Long userId);

}
