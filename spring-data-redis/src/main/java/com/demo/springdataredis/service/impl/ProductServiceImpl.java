package com.demo.springdataredis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.demo.springdataredis.mapper.ProductMapper;
import com.demo.springdataredis.model.Product;
import com.demo.springdataredis.repository.ProductRepository;
import com.demo.springdataredis.request.CreateProductRequest;
import com.demo.springdataredis.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	@Caching(evict = { @CacheEvict(value = "product", allEntries = true) })
	public Product save(CreateProductRequest productRequest) {
		Product product = ProductMapper.convertToProduct(productRequest);
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
			log.error("Exception occured: " + e);
		}
	}
}