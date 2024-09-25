package com.teste.criativa.funcionario;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioCreate(
		
		@NotBlank
		@Size(min = 1, max = 20)
	    String nome,
	    
	    @NotBlank
	    @Size(min = 1, max = 50)
		String sobrenome,
		
		@CPF
		@NotBlank(message = "CPF é obrigatório")
		String cpf,
		 
		@Enumerated
		Sexo sexo,
		 
		int idade
		
		 ){

}
