package com.teste.criativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.criativa.infra.DadosTokenJWT;
import com.teste.criativa.infra.SecurityConfigurations;
import com.teste.criativa.infra.TokenService;
import com.teste.criativa.usuarios.DadosAutenticacao;
import com.teste.criativa.usuarios.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
@Tag(name = "Usuario")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager maneger;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	@Operation(summary = "Usuario login", description = "Método para logar o usuario")
	@ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
	@ApiResponse(responseCode = "400", description = "Usuario não cadastrado")
	@ApiResponse(responseCode = "500", description = "Erro no servidor")
	public ResponseEntity<?> fazerLogin (@RequestBody @Valid DadosAutenticacao dados) {

		var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());

		var autenticacao = maneger.authenticate(token);

		var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
	
}
