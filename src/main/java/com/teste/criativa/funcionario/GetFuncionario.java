package com.teste.criativa.funcionario;

public record GetFuncionario(
		
		 Long id,
		 
		 String nome,
		 String sobrenome,
		 
		 Sexo sexo,
		 
		 int idade,
		 int cpf) {
	public GetFuncionario(Funcionario funcionario) {
		this(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSobrenome(),
				funcionario.getSexo(),
				funcionario.getIdade(),
				funcionario.getCpf());
	}


}
