package com.ukikos.shop.controller;

import com.ukikos.shop.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageservice;

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@RequestParam String link) throws IOException {
        byte[] imageBytes = imageservice.getImage(link);
        return ResponseEntity.ok(imageBytes);
    }
}
