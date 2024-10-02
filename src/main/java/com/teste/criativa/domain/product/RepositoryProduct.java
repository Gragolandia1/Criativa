package com.teste.criativa.domain.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, Long>{

	List<Product> findAllByAtivoTrue();

	List<Product> findAllByAtivoFalse();

}
