package com.teste.criativa.product;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record ProductCreate(
			
		@NotBlank
		String nome,
		
		int quantidade,
		
		double price,
		
		@Enumerated
		Fornecedor fornecedor) {

}
