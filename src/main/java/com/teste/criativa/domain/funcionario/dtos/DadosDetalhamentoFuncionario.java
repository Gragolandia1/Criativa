package com.teste.criativa.domain.funcionario.dtos;

import com.teste.criativa.domain.funcionario.Funcionario;
import com.teste.criativa.domain.funcionario.enums.Sexo;

public record DadosDetalhamentoFuncionario(

        Long id,

        String nome,

        String sobrenome,

        String cpf,

        Sexo sexo,

        Integer idade) {

    public DadosDetalhamentoFuncionario(Funcionario funcionario) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getCpf(),
                funcionario.getSexo(),
                funcionario.getIdade());
    }

}
