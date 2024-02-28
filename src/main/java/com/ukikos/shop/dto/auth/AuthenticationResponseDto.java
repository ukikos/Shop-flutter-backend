package com.ukikos.shop.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {

    private String accessToken;
}
