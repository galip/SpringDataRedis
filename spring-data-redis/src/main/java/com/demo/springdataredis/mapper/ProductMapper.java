package com.demo.springdataredis.mapper;

import com.demo.springdataredis.dto.ProductDto;
import com.demo.springdataredis.model.Product;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

	public static ProductDto convertToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		return productDto;

	}
}