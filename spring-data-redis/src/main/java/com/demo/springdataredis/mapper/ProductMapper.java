package com.demo.springdataredis.mapper;

import com.demo.springdataredis.dto.ProductDto;
import com.demo.springdataredis.model.Product;
import com.demo.springdataredis.request.CreateProductRequest;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

	public static ProductDto convertToDto(Product product) {
		if (product == null) {
			return new ProductDto();
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		return productDto;

	}
	
	public static Product convertToProduct(CreateProductRequest productRequest) {
		if(productRequest == null) {
			return new Product();
		}
		
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		product.setDescription(productRequest.getDescription());
		return product;
	}
}