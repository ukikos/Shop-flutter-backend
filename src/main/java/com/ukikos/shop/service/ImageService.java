package com.ukikos.shop.service;

import com.ukikos.shop.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class ImageService {

    private static final String IMAGES_FOLDER = "images";

    public byte[] getImage(String imageLink) throws IOException {
        Path imagePath = Path.of(IMAGES_FOLDER, imageLink);
        if (Files.exists(imagePath)) {
            return Files.readAllBytes(imagePath);
        } else {
            throw new ImageNotFoundException("Image with link " + imageLink + " not found");
        }
    }
}
