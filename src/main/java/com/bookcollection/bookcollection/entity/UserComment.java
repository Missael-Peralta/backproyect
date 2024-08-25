package com.bookcollection.bookcollection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_user", nullable = false, columnDefinition = "TEXT")
    private String message;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "date_comment", nullable = false)
    private LocalDateTime dateComment = LocalDateTime.now();
}
