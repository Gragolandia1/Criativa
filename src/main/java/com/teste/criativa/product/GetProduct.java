package com.teste.criativa.product;

public record GetProduct(
		
		Long id,
		
		String nome,
		
		int quantidade,
		
		double price,
		
		Fornecedor fornecedor,
		
		Boolean ativo ) {
	
	public GetProduct(Product product) {
		this(product.getId(),product.getNome(), product.getQuantidade(),product.getPrice(), product.getFornecedor(), product.getAtivo());
		
	}

}
