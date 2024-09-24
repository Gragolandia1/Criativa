create table funcionarios(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	sobrenome varchar(100) not null,
	cpf varchar(100) not null,
	sexo varchar(100) not null,
	idade int(20) not null,
	
	primary key(id)
	);