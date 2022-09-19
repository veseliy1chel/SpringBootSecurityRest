package com.study.springbootsecurityrest.repositories;

import com.study.springbootsecurityrest.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
    Optional<Shop> findByName(String name);
    Optional<Shop> findById(@Param("shop_id")int id);
}
