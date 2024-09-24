package com.teste.criativa.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	public Funcionario(CreateFuncionario dados) {
		this.nome = dados.nome();
		this.sobrenome = dados.sobrenome();
		this.sexo = dados.sexo();
		this.idade = dados.idade();
		this.cpf = dados.cpf();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String sexo;
	
	private int idade;
	
	private int cpf;

}
