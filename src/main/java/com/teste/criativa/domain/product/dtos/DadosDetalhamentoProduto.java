package com.teste.criativa.domain.product.dtos;

import com.teste.criativa.domain.product.Product;
import com.teste.criativa.domain.product.enums.Fornecedor;
import java.math.BigDecimal;


public record DadosDetalhamentoProduto(
    Long id,
	
	String nome,
	
	String codigoBarras,
	
	Integer quantidade,
	
	BigDecimal preco,
		
	Fornecedor fornecedor,

    Boolean ativo
	
	) {
        
        public DadosDetalhamentoProduto(Product product) {
            this(
                product.getId(),
                product.getNome(),
                product.getCodigoBarras(),
                product.getQuantidade(),
                product.getPreco(),
                product.getFornecedor(),
                product.getAtivo()
                );
        }

}
