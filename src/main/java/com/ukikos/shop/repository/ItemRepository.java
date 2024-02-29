package com.ukikos.shop.repository;

import com.ukikos.shop.entity.CategoryEntity;
import com.ukikos.shop.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    Page<ItemEntity> findAllByCategory(CategoryEntity category, Pageable pageable);

    Page<ItemEntity> findAllByCategoryId(Integer categoryId, Pageable pageable);
}
