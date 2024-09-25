package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.funcionario.FuncionarioCreate;
import com.teste.criativa.funcionario.Funcionario;
import com.teste.criativa.funcionario.RepositoryFuncionario;
import com.teste.criativa.funcionario.FuncionarioGet;
import com.teste.criativa.funcionario.FuncionarioUpdate;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	RepositoryFuncionario repository;
	
	@PostMapping
	@Transactional
	public void create (@RequestBody @Valid FuncionarioCreate dados) {
		repository.save(new Funcionario(dados));
	}
	
	@GetMapping
	public List<FuncionarioGet> getAll() {
		return repository.findAll().stream().map(FuncionarioGet::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void update (@RequestBody @Valid FuncionarioUpdate dados) {
		var funcionario = repository.getReferenceById(dados.id());
		funcionario.updateInformations(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete (@PathVariable Long id) {
		repository.deleteById(id); 
	}

}
