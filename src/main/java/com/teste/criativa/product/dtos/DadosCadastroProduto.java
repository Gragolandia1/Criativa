package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
			
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
