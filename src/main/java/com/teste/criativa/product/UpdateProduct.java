package com.teste.criativa.product;

public record UpdateProduct(
		Long id,
		
		String nome,
		
		int quantidade,
		
		Fornecedor fornecedor) {

}
