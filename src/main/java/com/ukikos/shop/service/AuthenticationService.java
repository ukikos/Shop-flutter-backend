package com.ukikos.shop.service;

import com.ukikos.shop.dto.auth.AuthenticationRequestDto;
import com.ukikos.shop.dto.auth.AuthenticationResponseDto;
import com.ukikos.shop.dto.auth.RegisterRequestDto;
import com.ukikos.shop.entity.Role;
import com.ukikos.shop.entity.UserEntity;
import com.ukikos.shop.exception.UserNotFoundException;
import com.ukikos.shop.repository.UserRepository;
import com.ukikos.shop.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDto register(RegisterRequestDto requestDto) {
        UserEntity user = UserEntity.builder()
                .email(requestDto.getEmail())
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .accessToken(jwtToken)
                .build();

    }

    public AuthenticationResponseDto login(AuthenticationRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getEmail(),
                        requestDto.getPassword()
                )
        );
        UserEntity user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User with email " + requestDto.getEmail() + " not found"));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .accessToken(jwtToken)
                .build();
    }
}
