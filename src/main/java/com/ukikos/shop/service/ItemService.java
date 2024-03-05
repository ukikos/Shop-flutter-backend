package com.ukikos.shop.service;

import com.ukikos.shop.dto.item.AttributeDto;
import com.ukikos.shop.dto.item.ItemFullResponseDto;
import com.ukikos.shop.dto.item.ItemResponseDto;
import com.ukikos.shop.entity.ItemAttributeEntity;
import com.ukikos.shop.entity.ItemEntity;
import com.ukikos.shop.exception.ItemNotFoundException;
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

    public Page<ItemResponseDto> getItemsPaginatedByCategoryId(Integer categoryId, Pageable pageable) {
        return itemRepository.findAllByCategoryId(categoryId, pageable).map(this::toItemResponseDto);
    }

    public ItemFullResponseDto getItemById(Integer itemId) {
        return itemRepository.findById(itemId).map(this::toItemFullResponseDto)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + "not found"));
    }

    public ItemResponseDto toItemResponseDto(ItemEntity entity) {
        return ItemResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .imageLink(entity.getImageLink())
                .categoryId(entity.getCategoryId())
                .build();
    }

    public ItemFullResponseDto toItemFullResponseDto(ItemEntity entity) {
        return ItemFullResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .imageLink(entity.getImageLink())
                .categoryId(entity.getCategoryId())
                .attributes(entity.getItemAttributes()
                        .stream()
                        .map(this::toAttributeDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public AttributeDto toAttributeDto(ItemAttributeEntity entity) {
        return AttributeDto.builder()
                .id(entity.getId())
                .name(entity.getAttribute().getName())
                .value(entity.getValue())
                .build();
    }
}
