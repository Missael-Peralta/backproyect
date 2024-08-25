package com.bookcollection.bookcollection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colection_name", nullable = false, length = 100)
    private String nameCollection;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "topic_category", nullable = false, length = 100)
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "custom_fields", columnDefinition = "JSONB")
    @Lob
    private String customFields;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();

    @OneToMany(mappedBy = "collection")
    private Set<Item> items = new HashSet<>();
}
