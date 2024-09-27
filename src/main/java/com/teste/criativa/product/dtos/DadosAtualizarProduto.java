package com.teste.criativa.product.dtos;

import com.teste.criativa.product.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdate(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		String codigoBarras,
		
		int quantidade,
		
		double price, 
		
		@Enumerated
		Fornecedor fornecedor) {

}
