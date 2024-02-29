package com.ukikos.shop.repository;

import com.ukikos.shop.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {

}
