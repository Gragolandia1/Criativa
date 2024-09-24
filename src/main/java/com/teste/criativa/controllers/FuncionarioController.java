package com.teste.criativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.funcionario.CreateFuncionario;
import com.teste.criativa.funcionario.Funcionario;
import com.teste.criativa.funcionario.FuncionarioRepository;
import com.teste.criativa.funcionario.GetFuncionario;
import com.teste.criativa.product.GetProduct;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository repository;
	
	@PostMapping
	public void create (@RequestBody CreateFuncionario dados) {
		repository.save(new Funcionario(dados));
	}
	
	@GetMapping
	public List<GetFuncionario> getAll() {
		return repository.findAll().stream().map(GetFuncionario::new).toList();
	}

}
