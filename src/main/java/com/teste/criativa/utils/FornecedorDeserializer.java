package com.teste.criativa.utils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.teste.criativa.domain.product.enums.Fornecedor;

import java.io.IOException;

public class FornecedorDeserializer extends JsonDeserializer<Fornecedor>{
    @Override
    public Fornecedor deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return Fornecedor.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IOException("Valor inválido para o campo Fornecedor: " + value);
        }
    }

}
