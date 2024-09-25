package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.criativa.product.ProductCreate;
import com.teste.criativa.product.ProductGet;
import com.teste.criativa.product.Product;
import com.teste.criativa.product.RepositoryProduct;
import com.teste.criativa.product.ProductUpdate;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	RepositoryProduct repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProductGet> create(@RequestBody @Valid ProductCreate dados, UriComponentsBuilder uriBuilder) {
		var product = new Product(dados);
		repository.save(product);
		
		var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
				
		return ResponseEntity.created(uri).body(new ProductGet(product));
	}
	
	@GetMapping("/true")
	public ResponseEntity<List<ProductGet>> getAllTrue() {
		var lista = repository.findAllByAtivoTrue().stream().map(ProductGet::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/false")
	public ResponseEntity<List<ProductGet>> getAllFalse() {
		var lista = repository.findAllByAtivoFalse().stream().map(ProductGet::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductGet> getById(@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new ProductGet(product));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<ProductGet> update(@RequestBody @Valid ProductUpdate dados) {
		var product = repository.getReferenceById(dados.id());
		product.updateInformations(dados);
		
		return ResponseEntity.ok(new ProductGet(product));
	}
	@PutMapping("ativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativar (@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		product.ativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativar (@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		product.inativar();
		
		return ResponseEntity.noContent().build();
	}
}

