package com.teste.criativa.domain.funcionario;


import com.teste.criativa.domain.funcionario.dtos.DadosAtualizarFuncionario;
import com.teste.criativa.domain.funcionario.dtos.DadosCadastroFuncionario;
import com.teste.criativa.domain.funcionario.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "funcionario")
@Table(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    public Funcionario(DadosCadastroFuncionario dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.cpf = dados.cpf();
        this.sexo = dados.sexo();
        this.idade = dados.idade();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String idade;

    public void atualizarInformacoes(@Valid DadosAtualizarFuncionario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.sobrenome() != null) {
            this.sobrenome = dados.sobrenome();
        }

        if (dados.sexo() != null) {
            this.sexo = dados.sexo();
        }
    }
}

	
