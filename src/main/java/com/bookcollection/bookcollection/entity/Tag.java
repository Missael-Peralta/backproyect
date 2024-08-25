package com.bookcollection.bookcollection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_tag", nullable = false,unique = true,length = 100)
    private String nameTag;
}
