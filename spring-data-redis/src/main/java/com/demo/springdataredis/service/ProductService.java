package com.demo.springdataredis.service;

import java.util.List;

import com.demo.springdataredis.model.Product;
import com.demo.springdataredis.request.CreateProductRequest;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product save(CreateProductRequest productRequest);

}