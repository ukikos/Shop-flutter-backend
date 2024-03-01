package com.ukikos.shop.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageNotFoundException extends RuntimeException {

    public ImageNotFoundException(String message) {
        super(message);
    }
}
