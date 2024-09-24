package com.teste.criativa.product;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record CreateProduct(
			
		@NotBlank
		String nome,
		
		int quantidade,
		
		double price,
		
		@Enumerated
		Fornecedor fornecedor) {

}
