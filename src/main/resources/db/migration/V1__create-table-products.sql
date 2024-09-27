create table products(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	codigoBarras char(13) not null UNIQUE,
	quantidade varchar(100) not null,
	preco varchar(100) not null,
	fornecedor varchar(100) not null,
	
	primary key(id)
	);