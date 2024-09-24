package com.teste.criativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.funcionario.CreateFuncionario;
import com.teste.criativa.funcionario.Funcionario;
import com.teste.criativa.funcionario.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository repository;
	
	@PostMapping
	public void create (@RequestBody CreateFuncionario dados) {
		repository.save(new Funcionario(dados));
	}

}
