package com.teste.criativa.funcionario;


public record GetFuncionario(
		
		 Long id,
		 
		 String nome,
		 String sobrenome,
		 String cpf,
		 
		 Sexo sexo,
		 
		 int idade
		  ) {
	public GetFuncionario(Funcionario funcionario) {
		this(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSobrenome(),
				funcionario.getCpf(),
				funcionario.getSexo(),
				funcionario.getIdade());
	}


}
