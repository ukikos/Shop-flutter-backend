package com.ukikos.shop.dto.item;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemFullResponseDto {

    private Integer id;

    private String name;

    private Integer price;

    private String imageLink;

    private Integer categoryId;

    private List<AttributeDto> attributes;
}
