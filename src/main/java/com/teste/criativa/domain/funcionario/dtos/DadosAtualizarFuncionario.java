package com.teste.criativa.domain.funcionario.dtos;

import com.teste.criativa.domain.funcionario.enums.Sexo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosAtualizarFuncionario(

        @NotNull
        Long id,

        @NotBlank
        @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
        @Size(max = 20, message = "O nome deve ter no maximo 20 caracteres")
        String nome,

        @NotBlank
        @Size(min = 3, message = "O sobrenome deve ter no minimo 3 caracteres")
        @Size(max = 30, message = "O sobrenome deve ter no maximo 30 caracteres")
        String sobrenome,

        @CPF
        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @Enumerated
        @NotNull(message = "O genero nao pode ser nulo")
        Sexo sexo,

        @NotBlank
        @Pattern(regexp = "\\d{18,60}", message = "Digite a idade corretamente")
        String idade

) {

}
