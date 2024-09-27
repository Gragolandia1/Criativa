package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import com.teste.criativa.product.Product;

public record DadosListagemProduto(
		
		Long id,
		
		String nome,
		
		String codigoBarras,
		
		String quantidade,
		
		String preco,
		
		Fornecedor fornecedor,
		
		Boolean ativo) {
	
	public DadosListagemProduto(Product product) {
		this(
				product.getId(),
				product.getNome(),
				product.getCodigoBarras(),
				product.getQuantidade(),
				product.getPreco(),
				product.getFornecedor(),
				product.getAtivo());
		
	}

}
