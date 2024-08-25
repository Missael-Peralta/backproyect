package com.bookcollection.bookcollection.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemTagId implements Serializable {
    private Long item;
    private Long tag;
}
