create table products(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	quantidade int(20) not null,
	price varchar(100) not null,
	fornecedor varchar(100) not null,
	
	primary key(id)
	);