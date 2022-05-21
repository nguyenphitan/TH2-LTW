package com.nhom10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.nhom10.entity.Product;
import com.nhom10.repository.ProductRepository;
import com.nhom10.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAlls() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public Product post(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Long id, Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	@Override
	public Boolean validate(Long id, String status, Model model, String code, String description, String price_raw) {
		Boolean validate = true;
		int count = 0;
		List<Product> products = productRepository.findAll();
		for(Product product : products) {
			if(code.equals(product.getCode())) {
	            count++;
			}
		}
		if(status.equals("add") && count > 0) {
			model.addAttribute("messageError", "code is existed.");
			validate = false;
		} else if(status.equals("update") && count > 1) {
			model.addAttribute("messageError", "code is existed.");
			validate = false;
		}
		
		String regex = "\\d+";
        if(code.equals("")) {
            model.addAttribute("messageError", "Code is not empty.");
            validate = false;
        } else if(description.equals("")) {
        	model.addAttribute("messageError", "Description is not empty.");
            validate = false;
        } else if(price_raw.equals("")) {
        	model.addAttribute("messageError", "Price is not empty.");
            validate = false;
        } else if( !price_raw.matches(regex) ) {
        	model.addAttribute("messageError", "Price is number.");
            validate = false;
        }
		
		if( !validate ) {
			if(status.equals("add")) {				
				model.addAttribute("code", code);
				model.addAttribute("description", description);
				model.addAttribute("price", price_raw);
			}
			else {
				model.addAttribute("product", productRepository.getById(id));
			}
			return false;
		}
		return true;
	}

}
