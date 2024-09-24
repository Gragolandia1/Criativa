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

import com.teste.criativa.product.CreateProduct;
import com.teste.criativa.product.DadosProduct;
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
	public ResponseEntity<DadosProduct> create(@RequestBody @Valid CreateProduct dados, UriComponentsBuilder uriBuilder) {
		var product = new Product(dados);
		repository.save(product);
		
		var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
				
		return ResponseEntity.created(uri).body(new DadosProduct(product));
	}
	
	@GetMapping("/true")
	public ResponseEntity<List<GetProduct>> getAllTrue() {
		var lista = repository.findAllByAtivoTrue().stream().map(GetProduct::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/false")
	public ResponseEntity<List<GetProduct>> getAllFalse() {
		var lista = repository.findAllByAtivoFalse().stream().map(GetProduct::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/{id}")
	public ResponseEntity<List<GetProduct>> getById(@PathVariable Long id) {
		var lista = repository.findById(id).stream().map(GetProduct::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosProduct> update(@RequestBody @Valid UpdateProduct dados) {
		var product = repository.getReferenceById(dados.id());
		product.updateInformations(dados);
		
		return ResponseEntity.ok(new DadosProduct(product));
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

