package com.teste.criativa.product;

import jakarta.validation.constraints.NotNull;

public record UpdateProduct(
		
		@NotNull
		Long id,
		
		String nome,
		
		int quantidade,
		
		double price, 
		
		Fornecedor fornecedor) {

}
