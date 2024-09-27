package com.teste.criativa.funcionario.dtos;

import com.teste.criativa.funcionario.enums.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroFuncionario(
		
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

		@NotBlank
		String idade
		
		 ){

}
