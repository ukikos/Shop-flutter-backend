package com.ukikos.shop.controller;

import com.ukikos.shop.dto.item.ItemResponseDto;
import com.ukikos.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{categoryId}") // пример запроса: localhost:8091/endpoint/test?categoryId=4&page=0&size=3&sort=id,DESC
    public ResponseEntity<Page<ItemResponseDto>> getAllItemsByCategoryId(
            @PathVariable Integer categoryId,
            Pageable pageable
    ) {
        Page<ItemResponseDto> items = itemService.getItemsPaginatedByCategoryId(categoryId, pageable);
        return ResponseEntity.ok(items);
    }
}
