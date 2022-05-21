package com.nhom10.service;

import java.util.List;

import org.springframework.ui.Model;

import com.nhom10.entity.Product;

public interface ProductService {
	List<Product> getAlls();
	Product getById(Long id);
	Product post(Product product);
	Product update(Long id, Product product);
	void delete(Long id);
	public Boolean validate(Long id, String status, Model model, String code, String description, String price_raw);
}
