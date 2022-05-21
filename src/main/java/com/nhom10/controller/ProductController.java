package com.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom10.entity.Product;
import com.nhom10.service.ProductService;

import lombok.Delegate;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public String productPage(Model model) {
		model.addAttribute("products", productService.getAlls());
		return "products";
	}
	
	@GetMapping("/detail")
	public String detailPage() {
		return "detail";
	}
	
	@PostMapping()
	public String post(
			Model model,
			@RequestParam("code") String code, 
			@RequestParam("description") String description, 
			@RequestParam("price") String price_raw
	) {
		String status = "add";
		Boolean validate = productService.validate(null, status, model, code, description, price_raw);
		if( !validate ) {
			return "detail";
		}
		Product product = new Product(null, code, description, Double.parseDouble(price_raw));
		productService.post(product);
		return "redirect:/products";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.getById(id));
		return "detail";
	}
	
	@PostMapping("/update/{id}")
	public String update(
			@PathVariable("id") Long id,
			@RequestParam("code") String code,
			@RequestParam("description") String description,
			@RequestParam("price") String price_raw,
			Model model
	) {
		String status = "update";
		Boolean validate = productService.validate(id, status, model, code, description, price_raw);
		if( !validate ) {
			return "detail";
		}
		Product product = new Product(id, code, description, Double.parseDouble(price_raw));
		productService.update(id, product);
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.getById(id));
		return "delete";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		productService.delete(id);
		return "redirect:/products";
	}
	
}
