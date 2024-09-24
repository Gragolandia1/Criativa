package com.teste.criativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.product.CreateProduct;
import com.teste.criativa.product.Product;
import com.teste.criativa.product.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@PostMapping
	public void create(@RequestBody CreateProduct dados) {
		repository.save(new Product(dados));
	}
}

