package com.demo.springdataredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springdataredis.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}