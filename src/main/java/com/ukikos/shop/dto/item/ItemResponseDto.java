package com.ukikos.shop.dto.item;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

    private Integer id;

    private String name;

    private Integer price;

    private String imageLink;

    private Integer categoryId;
}
