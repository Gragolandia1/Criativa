package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.criativa.product.dtos.DadosCadastroProduto;
import com.teste.criativa.product.dtos.DadosDetalhamentoProduto;
import com.teste.criativa.product.dtos.DadosListagemProduto;
import com.teste.criativa.product.enums.Fornecedor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.teste.criativa.infra.SecurityConfigurations;
import com.teste.criativa.product.Product;
import com.teste.criativa.product.RepositoryProduct;
import com.teste.criativa.product.dtos.DadosAtualizarProduto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
@Tag(name = "Produtos")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class ProductController {
	
	@Autowired
	RepositoryProduct repository;
		
	@PostMapping
	@Transactional
	@Operation(summary = "Cadastrar produto", description = "Método para cadastrar um produto")
	@ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso")
	@ApiResponse(responseCode = "400", description = "Produto não cadastrado")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<DadosListagemProduto> create(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
		var product = new Product(dados);
		repository.save(product);
		
		var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
				
		return ResponseEntity.created(uri).body(new DadosListagemProduto(product));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca de produto por ID", description = "Método para encontrar produtos por ID")
	@ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "404", description = "Produto não encontrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<DadosListagemProduto> getById(@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemProduto(product));
	}
	
	@GetMapping
	@Operation(summary = "Busca de produtos", description = "Método para encontrar produtos cadastrados")
	@ApiResponse(responseCode = "200", description = "Produtos encontrados com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity <List<DadosListagemProduto>> getProducts (
		@RequestParam (value = "ativo", required = false, defaultValue = "true") Boolean ativo,
		@RequestParam(value = "nome", required = false) String nome,
		@RequestParam(value = "fornecedor", required = false) Fornecedor fornecedor) {

			var lista = repository.findAll().stream()

			.filter(produto -> ativo == null || (ativo ? produto.getAtivo() : !produto.getAtivo()))

			.filter(produto -> nome == null || produto.getNome().contains(nome))

			.filter(produto -> fornecedor == null || produto.getFornecedor().equals(fornecedor))

			.map(DadosListagemProduto::new)

			.toList();

        return ResponseEntity.ok(lista);
    }

	@PutMapping
	@Transactional
	@Operation(summary = "Atualizar produto", description = "Método para atualizar produtos cadastrados")
	@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "404", description = "Produto não encontrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<DadosDetalhamentoProduto> update(@RequestBody @Valid DadosAtualizarProduto dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.updateInformations(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
	}

	@PutMapping("ativar/{id}")
	@Transactional
	@Operation(summary = "Ativar produto por ID", description = "Método para ativar um produto")
	@ApiResponse(responseCode = "204", description = "Produto ativado com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "404", description = "Produto não encontrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<Void> reativar (@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		product.ativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar produto por ID", description = "Método para deletar um produto")
	@ApiResponse(responseCode = "204", description = "Produto Deletado com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "404", description = "Produto não encontrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	@Transactional
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("inativar/{id}")
	@Transactional
	@Operation(summary = "Desativar produto por ID", description = "Método para desativar um produto")
	@ApiResponse(responseCode = "204", description = "Produto inativado com sucesso")
	@ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
	@ApiResponse(responseCode = "404", description = "Produto não encontrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<Void> inativar (@PathVariable Long id) {
		var product = repository.getReferenceById(id);
		product.inativar();
		
		return ResponseEntity.noContent().build();
	}
}

