package com.teste.criativa.product.dtos;

import com.teste.criativa.product.enums.Fornecedor;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record DadosCadastroProduto(
		
		@NotBlank
		@Size(max = 50, message = "O nome não pode ter mais de 50 caracteres")
		String nome,
		
		@NotBlank
		@Pattern(regexp = "\\d{6,13}", message = "Formato do codigo de barras é inválido. Deve conter entre 6 e 13 dígitos")
		String codigoBarras,
		
		@Min(value = 1, message = "A quantidade deve ser maior que zero")
		@NotNull
		Integer quantidade,
		
		@Positive
		@NotNull
		BigDecimal preco,
		
		@Enumerated
		@NotNull(message = "O fornecedor não pode ser nulo")
		Fornecedor fornecedor) {	

}
