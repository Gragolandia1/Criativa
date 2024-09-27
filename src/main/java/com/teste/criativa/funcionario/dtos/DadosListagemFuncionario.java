package com.teste.criativa.funcionario.dtos;

import com.teste.criativa.funcionario.Funcionario;
import com.teste.criativa.funcionario.enums.Sexo;

public record DadosListagemFuncionario(

		Long id,

		String nome,

		String sobrenome,

		String cpf,

		Sexo sexo,

		String idade
) {
	public DadosListagemFuncionario(Funcionario funcionario) {
		this(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSobrenome(),
				funcionario.getCpf(),
				funcionario.getSexo(),
				funcionario.getIdade());
	}


}