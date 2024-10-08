<h1 align="center">
  API de Controle de Produtos e Funcionários
</h1>

Esta API foi desenvolvida para gerenciar produtos e funcionários de forma eficiente. Ela permite o cadastro, atualização, remoção e visualização de dados, com autenticação segura e validação dos dados enviados.

Importante : A API ainda não esta com todas as funcionalidades, então para fazer login deverá fazer um cadastro manual do usuario por linha de comando usando o MySQL, em breve farei a funcionalidade de cadastro do usuario pela API.

## Funcionalidades
 
- Autenticação com JWT: A API oferece um método de login que retorna um token JWT (JSON Web Token), que é necessário para realizar as requisições. Esse token garante a segurança do acesso e controle das operações realizadas.
- Gerenciamento de Produtos e Funcionários: A API suporta CRUD completo (Create, Read, Update, Delete) para ambos.
- Validação de Dados: Utilizei o Hibernate Validation para garantir que todos os dados enviados sejam válidos e atendam aos critérios necessários.
- Tratamento de Exceções: Erros são tratados de maneira robusta para fornecer feedback adequado aos usuários em caso de falhas.
- Banco de Dados MySQL: A persistência de dados é feita utilizando o banco de dados MySQL, garantindo armazenamento seguro e eficiente das informações.

## Tecnologias

- Spring Boot: Framework principal para o desenvolvimento da aplicação.
- MySQL: Banco de dados utilizado para persistência de dados.
- JWT: Para autenticação baseada em token.
- Bean Validation: Para validação automática de dados de entrada.
- Swagger para a documentação

