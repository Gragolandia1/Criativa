package com.teste.criativa.domain.funcionario.dtos;

import com.teste.criativa.domain.funcionario.Funcionario;
import com.teste.criativa.domain.funcionario.enums.Sexo;

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