create table remedios(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	quantidade varchar(100) not null,
	fornecedor varchar(100) not null,
	
	primary key(id)
	);