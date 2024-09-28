package com.teste.criativa.product.dtos;

import com.teste.criativa.product.Product;
import com.teste.criativa.product.enums.Fornecedor;


public record DadosDetalhamentoProduto(
    Long id,
	
	String nome,
	
	String codigoBarras,
	
	String quantidade,
	
	String preco,
		
	Fornecedor fornecedor,
	
	Boolean ativo) {
        
        public DadosDetalhamentoProduto(Product product) {
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
