package com.teste.criativa.product;

public record ProductGet(
		
		Long id,
		
		String nome,
		
		String codigoBarras,
		
		int quantidade,
		
		double price,
		
		Fornecedor fornecedor,
		
		Boolean ativo) {
	
	public ProductGet(Product product) {
		this(
				product.getId(),
				product.getNome(),
				product.getCodigoBarras(),
				product.getQuantidade(),
				product.getPrice(),
				product.getFornecedor(),
				product.getAtivo());
		
	}

}
