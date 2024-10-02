package com.teste.criativa.domain.product;

import com.teste.criativa.domain.product.dtos.DadosCadastroProduto;
import com.teste.criativa.domain.product.dtos.DadosAtualizarProduto;
import com.teste.criativa.domain.product.enums.Fornecedor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Product")
@Table(name = "products")
@EqualsAndHashCode(of = "id")
public class Product {
		
	public Product(DadosCadastroProduto dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.codigoBarras = dados.codigoBarras();
		this.quantidade = dados.quantidade();
		this.preco = dados.preco();
		this.fornecedor = dados.fornecedor();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String codigoBarras;
	
	private Integer quantidade;
	
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private Fornecedor fornecedor;
	
	private Boolean ativo;

	public void updateInformations(@Valid DadosAtualizarProduto dados) {
		
		if(dados.nome()!= null ) {
		this.nome = dados.nome();
		}
		if(dados.codigoBarras()!= null ) {
			this.codigoBarras = dados.codigoBarras();
		}
		if(dados.quantidade()!= null ) {
			this.quantidade = dados.quantidade();
		}
		if(dados.preco()!= null ) {
			this.preco = dados.preco();
		}
		if(dados.fornecedor()!= null ) {
			this.fornecedor = dados.fornecedor();
		}
		
	}

	public void inativar() {
		this.ativo = false;
	}

	public void ativar() {
		this.ativo = true;
		
	}
	
}

