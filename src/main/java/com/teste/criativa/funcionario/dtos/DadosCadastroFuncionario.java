package com.teste.criativa.funcionario.dtos;

import com.teste.criativa.funcionario.enums.Sexo;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroFuncionario(
		
		@NotBlank
		@Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
		@Size(max = 20, message = "O nome deve ter no maximo 20 caracteres")
	    String nome,
	    
	    @NotBlank
	    @Size(min = 3, message = "O sobrenome deve ter no minimo 3 caracteres")
		@Size(max = 30, message = "O sobrenome deve ter no maximo 30 caracteres")
		String sobrenome,
		
		@CPF
		String cpf,
		 
		@Enumerated
		@NotNull(message = "O genero nao pode ser nulo")
        Sexo sexo,

		@NotBlank
		@Min(value = 18, message = "Idade invalida")
		String idade
		
		 ){

}
