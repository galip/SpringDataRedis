package com.demo.springdataredis.response;

import com.demo.springdataredis.dto.ProductDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateProductResponse {

	private ProductDto productDto;

}