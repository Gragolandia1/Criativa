package com.teste.criativa.funcionario.dtos;

import com.teste.criativa.funcionario.enums.Sexo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosAtualizarFuncionario(

		@NotNull
		Long id,

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
