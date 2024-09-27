package com.teste.criativa.funcionario;


import com.teste.criativa.funcionario.dtos.DadosAtualizarFuncionario;
import com.teste.criativa.funcionario.dtos.DadosCadastroFuncionario;
import com.teste.criativa.funcionario.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "funcionario")
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

	public void atualizarInformacoes (@Valid DadosAtualizarFuncionario dados) {
		if(dados.nome()!= null ) {
		this.nome = dados.nome();
		}
		if(dados.sobrenome()!= null ) {
			this.sobrenome = dados.sobrenome();
		}
		
		if(dados.sexo()!= null ) {
			this.sexo = dados.sexo();
		}
	}
}

	
