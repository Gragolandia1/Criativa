alter table products
    add ativo tinyint;
update products
set ativo = 1;
