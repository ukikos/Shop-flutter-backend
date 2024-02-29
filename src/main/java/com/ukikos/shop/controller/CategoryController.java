package com.ukikos.shop.controller;

import com.ukikos.shop.dto.category.CategoryResponseDto;
import com.ukikos.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getRootCategories() {
        return ResponseEntity.ok(categoryService.getRootCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<CategoryResponseDto>> getChildCategoriesById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(categoryService.getChildCategoriesById(categoryId));
    }
}
