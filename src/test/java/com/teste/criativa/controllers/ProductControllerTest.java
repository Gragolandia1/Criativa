package com.teste.criativa.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.criativa.domain.product.RepositoryProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RepositoryProduct repository;

    @Test
    @WithMockUser
    public void deveCadastrarProdutoComSucesso() throws Exception {
        String jsonRequest = "{\"nome\":\"Produto Teste\",\"codigoBarras\":\"221312512\",\"quantidade\":1,\"preco\":2.00,\"fornecedor\":\"REVAL\"}";

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON) // Especifica o tipo MIME
                        .content(jsonRequest)) // Aqui você coloca o JSON como conteúdo
                .andExpect(status().isCreated());
    }
    @Test
    @WithMockUser
    public void deveRetornarBadRequestQuandoNomeNaoForInformado() throws Exception {
        String jsonRequest = "{\"codigoBarras\":\"221312512\",\"quantidade\":1,\"preco\":2.00,\"fornecedor\":\"REVAL\"}";

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()); // Espera um 400 Bad Request
    }


    @Test
    void getById() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void update() {
    }

    @Test
    void reativar() {
    }

    @Test
    void delete() {
    }

    @Test
    void inativar() {
    }
}