package com.demo.springdataredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springdataredis.mapper.ProductMapper;
import com.demo.springdataredis.model.Product;
import com.demo.springdataredis.request.CreateProductRequest;
import com.demo.springdataredis.response.CreateProductResponse;
import com.demo.springdataredis.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/all")
	@Cacheable(value = "product")
	List<Product> findAll() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	@Cacheable(value = "product", key = "#id")
	Product findById(@PathVariable long id) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productService.getProductById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<CreateProductResponse> save(@RequestBody CreateProductRequest productRequest) {
		CreateProductResponse productResponse = new CreateProductResponse();
		
		Product product = productService.save(productRequest);
		productResponse.setProductDto(ProductMapper.convertToDto(product));
		
		return ResponseEntity.ok(productResponse);
	}
}