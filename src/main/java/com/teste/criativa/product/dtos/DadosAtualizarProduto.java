package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		@NotBlank
		String codigoBarras,
		
		@NotBlank
		String quantidade,
		
		@NotBlank
		String preco, 
		
		@Enumerated
		Fornecedor fornecedor) {

}
