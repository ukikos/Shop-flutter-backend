package com.ukikos.shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false, nullable = false)
    private CategoryEntity category;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<ItemAttributeEntity> itemAttributes;
}
