package com.teste.criativa.domain.product.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.teste.criativa.utils.FornecedorDeserializer;

@JsonDeserialize(using = FornecedorDeserializer.class)
public enum Fornecedor {

    REVAL,

    MABEL

}
