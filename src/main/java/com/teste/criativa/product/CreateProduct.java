package com.teste.criativa.product;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record CreateProduct(
		
		@NotBlank
		String nome,
		
		int quantidade,
		
		@Enumerated
		Fornecedor fornecedor) {

}
