package com.ukikos.shop.service;

import com.ukikos.shop.dto.item.AttributeDto;
import com.ukikos.shop.dto.item.ItemFullResponseDto;
import com.ukikos.shop.dto.item.ItemResponseDto;
import com.ukikos.shop.entity.AttributeEntity;
import com.ukikos.shop.entity.ItemAttributeEntity;
import com.ukikos.shop.entity.ItemEntity;
import com.ukikos.shop.exception.ItemNotFoundException;
import com.ukikos.shop.repository.ItemAttributeRepository;
import com.ukikos.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemAttributeRepository itemAttributeRepository;

    public Page<ItemResponseDto> getItemsPaginatedByCategoryId(Integer categoryId, Pageable pageable) {
        return itemRepository.findAllByCategoryId(categoryId, pageable).map(this::categoryEntityToCategoryResponseDto);
    }

    public ItemFullResponseDto getItemById(Integer itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + "not found"));
        return toItemFullResponseDto(itemEntity);
    }

    public ItemResponseDto categoryEntityToCategoryResponseDto(ItemEntity entity) {
        return ItemResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .categoryId(entity.getCategoryId())
                .build();
    }

    public ItemFullResponseDto toItemFullResponseDto(ItemEntity itemEntity) {
        return ItemFullResponseDto.builder()
                .id(itemEntity.getId())
                .name(itemEntity.getName())
                .price(itemEntity.getPrice())
                .categoryId(itemEntity.getCategoryId())
                .attributes(itemEntity.getItemAttributes()
                        .stream()
                        .map(this::toAttributeDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public AttributeDto toAttributeDto(ItemAttributeEntity entity) {
        return AttributeDto.builder()
                .id(entity.getId())
                .attribute(entity.getAttribute().getName())
                .value(entity.getValue())
                .build();
    }
}
