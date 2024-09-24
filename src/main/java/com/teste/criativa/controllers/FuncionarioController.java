package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.funcionario.CreateFuncionario;
import com.teste.criativa.funcionario.Funcionario;
import com.teste.criativa.funcionario.FuncionarioRepository;
import com.teste.criativa.funcionario.GetFuncionario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository repository;
	
	@PostMapping
	@Transactional
	public void create (@RequestBody @Valid CreateFuncionario dados) {
		repository.save(new Funcionario(dados));
	}
	
	@GetMapping
	public List<GetFuncionario> getAll() {
		return repository.findAll().stream().map(GetFuncionario::new).toList();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete (@PathVariable Long id) {
		repository.deleteById(id); 
	}

}
