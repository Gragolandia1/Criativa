package com.teste.criativa.funcionario;

import jakarta.persistence.Enumerated;

public record CreateFuncionario(
	     String nome,
		 String sobrenome,
		 
		 @Enumerated
		 Sexo sexo,
		 
		 int idade,
		 int cpf ){

}
