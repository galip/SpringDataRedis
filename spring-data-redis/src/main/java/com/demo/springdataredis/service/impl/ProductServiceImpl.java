package com.demo.springdataredis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.springdataredis.model.Product;
import com.demo.springdataredis.repository.ProductRepository;
import com.demo.springdataredis.request.CreateProductRequest;
import com.demo.springdataredis.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	@Cacheable(value = "product")
	public List<Product> getAllProducts() {
		getLongProcess();
		return productRepository.findAll();
	}

	@Override
	public Product save(CreateProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		product.setDescription(productRequest.getDescription());
		return productRepository.save(product);
	}

	@Override
	@Cacheable(value = "product", key = "#productId")
	public Product getProductById(long productId) {
		getLongProcess();
		Optional<Product> productOpt = productRepository.findById(productId);
		return productOpt.isPresent() ? productOpt.get() : new Product();
	}
	
	private void getLongProcess() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}