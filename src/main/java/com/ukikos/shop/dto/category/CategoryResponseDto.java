package com.ukikos.shop.dto.category;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private Integer id;

    private String name;

    private String imageLink;

    private Integer parentId;

    private Boolean isLast;
}
