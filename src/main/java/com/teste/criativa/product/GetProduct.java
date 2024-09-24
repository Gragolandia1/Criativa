package com.teste.criativa.product;

public record GetProduct(
		String nome,
		
		int quantidade,
		
		Fornecedor fornecedor) {
	
	public GetProduct(Product product) {
		this(product.getNome(), product.getQuantidade(), product.getFornecedor());
		
	}

}
