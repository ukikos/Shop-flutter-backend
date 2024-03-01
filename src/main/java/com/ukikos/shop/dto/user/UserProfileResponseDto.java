package com.ukikos.shop.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDto {

    private Integer id;

    private String email;

    private String firstName;

    private String lastName;
}
