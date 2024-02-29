package com.ukikos.shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_attributes")
public class ItemAttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false, nullable = false)
    private ItemEntity item;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", insertable = false, updatable = false, nullable = false)
    private AttributeEntity attribute;

    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    @Column(name = "value", nullable = false)
    private String value;
}
