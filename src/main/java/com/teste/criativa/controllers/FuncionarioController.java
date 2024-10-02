package com.teste.criativa.controllers;

import com.teste.criativa.domain.funcionario.Funcionario;
import com.teste.criativa.domain.funcionario.RepositoryFuncionario;
import com.teste.criativa.domain.funcionario.dtos.DadosAtualizarFuncionario;
import com.teste.criativa.domain.funcionario.dtos.DadosCadastroFuncionario;
import com.teste.criativa.domain.funcionario.dtos.DadosDetalhamentoFuncionario;
import com.teste.criativa.domain.funcionario.dtos.DadosListagemFuncionario;
import com.teste.criativa.infra.SecurityConfigurations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionarios")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class FuncionarioController {

    @Autowired
    RepositoryFuncionario repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar funcionario", description = "Método para cadastrar um funcionario")
    @ApiResponse(responseCode = "204", description = "Funcionario cadastardo com sucesso")
    @ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<DadosListagemFuncionario> create(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder) {
        var funcionario = new Funcionario(dados);
        repository.save(funcionario);

        var uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemFuncionario(funcionario));
    }

    @GetMapping
    @Operation(summary = "Busca de funcionarios", description = "Método para encontrar funcionarios cadastrados")
    @ApiResponse(responseCode = "200", description = "Funcionarios encontrados com sucesso")
    @ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<List<DadosListagemFuncionario>> getAll() {
        var lista = repository.findAll().stream().map(DadosListagemFuncionario::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar funcionario", description = "Método para atualizar um funcionario cadastrados")
    @ApiResponse(responseCode = "200", description = "Funcionario atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<DadosDetalhamentoFuncionario> update(@RequestBody @Valid DadosAtualizarFuncionario dados) {
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Deletar funcionario por ID", description = "Método para deletar um funcionario")
    @ApiResponse(responseCode = "204", description = "Funcionario Deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Token invalido ou expirado")
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
