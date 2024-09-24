package com.teste.criativa.funcionario;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateFuncionario(
		@NotNull
		Long id,
		
		@NotBlank
		@Size(min = 1, max = 20)
		String nome,
		
		@NotBlank
		@Size(min = 1, max = 50)
		String sobrenome,
		
		@CPF
		@NotBlank
		String cpf,
		
		@Enumerated
		Sexo sexo,
		 
		int idade) {

}
