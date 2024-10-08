package com.teste.criativa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.teste.criativa.domain.product.enums.Fornecedor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.coercionConfigFor(Fornecedor.class)
                .setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsNull);
        return mapper;
    }

}
