package com.nhom10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom10.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByCode(String code);
}
