package com.study.springbootsecurityrest.repositories;

import com.study.springbootsecurityrest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
        Optional<Product> findByName(String name);

    }