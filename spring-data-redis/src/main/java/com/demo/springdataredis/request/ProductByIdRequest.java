package com.demo.springdataredis.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductByIdRequest {

	private long id;

}