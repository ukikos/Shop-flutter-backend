package com.ukikos.shop.service;

import com.ukikos.shop.dto.item.ItemResponseDto;
import com.ukikos.shop.entity.ItemEntity;
import com.ukikos.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Page<ItemResponseDto> getItemsPaginatedByCategoryId(Integer categoryId, Pageable pageable) {
        return itemRepository.findAllByCategoryId(categoryId, pageable).map(this::categoryEntityToCategoryResponseDto);
    }

    public ItemResponseDto categoryEntityToCategoryResponseDto(ItemEntity entity) {
        return ItemResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .categoryId(entity.getCategoryId())
                .build();
    }
}
