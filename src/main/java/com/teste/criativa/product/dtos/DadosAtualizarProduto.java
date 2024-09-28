package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizarProduto(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		@NotBlank
		@Size(max = 13, message = "O codigo de barras não pode ter mais de 13 caracteres.")
		String codigoBarras,
		
		@NotBlank
		String quantidade,
		
		@NotBlank
		String preco, 
		
		@Enumerated
		Fornecedor fornecedor) {

}
