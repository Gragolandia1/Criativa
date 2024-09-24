package com.teste.criativa.funcionario;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record CreateFuncionario(
		
		@NotBlank
	    String nome,
	    
	    @NotBlank
		String sobrenome,
		
		@CPF
		@NotBlank(message = "CPF é obrigatório")
		String cpf,
		 
		@Enumerated
		Sexo sexo,
		 
		int idade
		
		 ){

}
