create table products
(

    id           BIGINT         NOT null auto_increment,
    nome         VARCHAR(100)   not null,
    codigoBarras CHAR(13)       not null UNIQUE,
    quantidade   INT(100)       not null,
    preco        DECIMAL(10, 2) not null,
    fornecedor   VARCHAR(100)   not null,

    primary key (id)
);