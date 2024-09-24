package com.teste.criativa.product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "product")
@Table(name = "products")
@EqualsAndHashCode(of = "id")
public class Product {
	
	public Product(CreateProduct dados) {
		this.nome = dados.nome();
		this.quantidade = dados.quantidade();
		this.fornecedor = dados.fornecedor();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private int quantidade;
	
	@Enumerated(EnumType.STRING)
	private Fornecedor fornecedor;

	public void updateInformations(UpdateProduct dados) {
		
		if(dados.nome()!= null ) {
		this.nome = dados.nome();
		}
		
		if(dados.fornecedor()!= null ) {
			this.fornecedor = dados.fornecedor();
		}
	}

}
