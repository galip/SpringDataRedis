package com.demo.springdataredis.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "product")
@Accessors(chain = true)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 7328527175502615992L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "DESCRIPTION")
	private String description;

}