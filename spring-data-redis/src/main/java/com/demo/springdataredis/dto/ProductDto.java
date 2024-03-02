package com.demo.springdataredis.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDto {

	private Long id;
	private String name;
	private double price;
	private String description;

}