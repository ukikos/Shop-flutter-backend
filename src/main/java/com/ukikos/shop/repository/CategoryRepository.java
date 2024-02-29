package com.ukikos.shop.repository;

import com.ukikos.shop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findAllByParentId(Integer parentId);
}
