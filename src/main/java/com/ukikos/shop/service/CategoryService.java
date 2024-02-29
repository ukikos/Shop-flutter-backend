package com.ukikos.shop.service;

import com.ukikos.shop.dto.category.CategoryResponseDto;
import com.ukikos.shop.entity.CategoryEntity;
import com.ukikos.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getRootCategories() {
        List<CategoryEntity> entities = categoryRepository.findAllByParentId(null);
        return entities.stream().map(this::categoryEntityToCategoryResponseDto).collect(Collectors.toList());
    }

    public List<CategoryResponseDto> getChildCategoriesById(Integer categoryId) {
        List<CategoryEntity> entities = categoryRepository.findAllByParentId(categoryId);
        return entities.stream().map(this::categoryEntityToCategoryResponseDto).collect(Collectors.toList());
    }

    public CategoryResponseDto categoryEntityToCategoryResponseDto(CategoryEntity entity) {
        return CategoryResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .imageLink(entity.getImageLink())
                .parentId(entity.getParentId())
                .isLast(entity.getIsLast())
                .build();
    }
}
