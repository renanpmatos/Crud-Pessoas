<div align="center">
  <h1 align="center">Crud Pessoas</h1>
</div>

## 📋 <a name="table">Conteúdos</a>

1. 👋 [Introdução](#introduction)
2. ⚙️ [Tech Stack](#tech-stack)
3. ⚡ [Execução do Projeto](#quick-start)

## <a name="introduction">👋 Introdução</a>

Um desafio para criar uma aplicação CRUD em 1 fim de semana, usando Spring Boot pela primeira vez!

Com o tema de "Cadastro de Pessoas", a aplicação faz as operações básicas de inserção, leitura, alteração e exclusão dos dados, salvando-os em um bando de dados MySql.

A API foi feita com o framework Spring Boot, que permite uma criação fácil e manipulação dinâmica dos dados na forma de API.
Além disso, foram utilizados JQuery para o front-end, que contava com um design feito em Bootstrap, para facilitar e agilizar o processo de criação e desenvolvimento das interfaces.

Para sua criação, utilizei principalmente a documentação do Spring Boot para desenvolver a API e a documentção do Bootstrap para o frontend:

[SpringBoot] <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">Documentação Spring Boot</a>
[Bootstrap] <a href="https://getbootstrap.com/docs/4.1/getting-started/introduction/">Documentação Bootstrap</a>

## <a name="tech-stack">⚙️ Tech Stack</a>

- Spring Boot
- Html, CSS e Javascript vanilla
- Bootstrap

## <a name="quick-start">⚡ Execução do Projeto</a>

**Pré-requisitos para excutar**

- [Java](https://www.java.com/pt-BR/)
- [MySQL](https://www.mysql.com/downloads/)


**Configuração no MySql:**

Primeiramente crie uma nova conexão no MySql Workbench e configure o nome de usuário e senha (por padrão deixe o nome como "root").

Em seguida, abra uma nova query Sql e digite o seguinte comando para criar uma nova base de dados:

```mysql 
create database bdpessoas;
```

Assim será criado um novo banco de nome "bdpessoas";
Agora crie a tabela pelo comando:

```mysql

use bdpessoas;

create table pessoas(
    id_pessoa int not null auto_increment primary key,
    nome varchar(50) not null,
    email varchar(50) not null,
    tipo varchar(50) not null,
    cpf varchar(50) unique,
    cnpj varchar(50) unique,
    cep varchar(10) not null,
    endereco varchar(255),
    logradouro varchar(255),
    bairro varchar(255),
    cidade varchar(255),
    estado varchar(255)
);
```

Dessa forma, estaremos informando que usamos o banco bdpessoas e criando uma tabela "pessoas" nele.

* Por padrão o MySql faz conexões em localhost:3306
##
### Configuração no Eclipse:

Após a configuração do banco de dados no MySql Workbench, basta abrir o projeto no Eclipse e executá-lo normalmente.

Para visualizar o projeto executado, basta abrir seu navegador e digitar o link "http://localhost:8080", que carregará o projeto.

Apenas abra [http://localhost:3000](http://localhost:3000) no seu navegador para visualizar o projeto 🤯.
