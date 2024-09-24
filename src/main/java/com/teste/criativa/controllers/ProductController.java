package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.product.CreateProduct;
import com.teste.criativa.product.GetProduct;
import com.teste.criativa.product.Product;
import com.teste.criativa.product.ProductRepository;
import com.teste.criativa.product.UpdateProduct;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid CreateProduct dados) {
		repository.save(new Product(dados));
	}
	
	@GetMapping
	public List<GetProduct> getAll() {
		return repository.findAll().stream().map(GetProduct::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid UpdateProduct dados) {
		var product = repository.getReferenceById(dados.id());
		product.updateInformations(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete (@PathVariable Long id) {
		repository.deleteById(id); 
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional
	public void inativar (@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		product.inativar();
	}
}

