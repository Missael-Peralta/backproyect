package com.bookcollection.bookcollection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_item", nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;

    @Column(name = "custom_fields", columnDefinition = "JSONB")
    @Lob
    private String customFields;

    @Column(name = "tags", columnDefinition = "TEXT[]")
    private String[] tags;

    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded = LocalDateTime.now();

    @Column(name = "img_url", length = 512)
    private String imgUrl;

}
