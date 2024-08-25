package com.bookcollection.bookcollection.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item_tag")
@IdClass(ItemTagId.class)
@Data
public class ItemTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false )
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
