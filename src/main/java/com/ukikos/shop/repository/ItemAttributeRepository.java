package com.ukikos.shop.repository;

import com.ukikos.shop.entity.ItemAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemAttributeRepository extends JpaRepository<ItemAttributeEntity, Integer> {

    List<ItemAttributeEntity> findAllByItemId(Integer itemId);
}
