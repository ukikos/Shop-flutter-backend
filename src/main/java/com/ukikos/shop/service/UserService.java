package com.ukikos.shop.service;

import com.ukikos.shop.dto.user.UserProfileResponseDto;
import com.ukikos.shop.entity.UserEntity;
import com.ukikos.shop.exception.UserNotFoundException;
import com.ukikos.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserProfileResponseDto getUserById(Integer userId) {
        UserEntity entity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        return toUserProfileDto(entity);
    }

    public UserProfileResponseDto getUserByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
        return toUserProfileDto(entity);
    }

    public UserProfileResponseDto toUserProfileDto(UserEntity entity) {
        return UserProfileResponseDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
}
