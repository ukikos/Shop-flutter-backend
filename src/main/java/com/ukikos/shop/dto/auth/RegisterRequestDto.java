package com.ukikos.shop.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    private String email;

    private String firstName;

    private String lastName;

    private String password;
}
