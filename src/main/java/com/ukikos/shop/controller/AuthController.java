package com.ukikos.shop.controller;

import com.ukikos.shop.dto.auth.AuthenticationRequestDto;
import com.ukikos.shop.dto.auth.RegisterRequestDto;
import com.ukikos.shop.dto.auth.AuthenticationResponseDto;
import com.ukikos.shop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
