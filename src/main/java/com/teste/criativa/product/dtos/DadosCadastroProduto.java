package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record DadosCadastroProduto(
		
		@NotBlank
		@Size(max = 50, message = "O nome não pode ter mais de 50 caracteres")
		String nome,
		
		@NotBlank
		@Size(max = 13, message = "O codigo de barras não pode ter mais de 13 caracteres.")
		String codigoBarras,
		
		@Min(value = 1, message = "A quantidade deve ser maior que zero")
		@NotNull(message = "A quantidade não pode estar em branco")
		Integer quantidade,
		
		@Positive
		@NotNull(message = "O preço não pode estar em branco")
		BigDecimal preco,
		
		@Enumerated
		Fornecedor fornecedor) {	

}
