package com.ukikos.shop.dto.item;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDto {

    private Integer id;

    private String name;

    private String value;
}
