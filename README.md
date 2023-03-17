# Crud-Pessoas

### Este é um projeto de Crud simples, com o tema de cadastro de Pessoas.

Para o desenvolvimento do projeto foi utilizado um banco de dados MySql, que faria conexão com uma API desenvolvida em Java
A API foi feita com o framework Spring Boot, que permite uma criação fácil e manipulação dinâmica dos dados na forma de API.

Além disso, foram utilizados JQuery para o front-end, que contava com um design feito em Bootstrap, para facilitar e agilizar o processo de criação e desenvolvimento das interfaces.

Caso queira Executar o projeto como um todo, apenas será necessário possuir o MySql e MySql Workbench instalados, bem como o Eclipse para executá-lo em si.

##
### Configuração no MySql:

Primeiramente crie uma nova conexão no MySql Workbench e configure o nome de usuário e senha (por padrão deixe o nome como "root" e senha como "gal1l3ug@me3702").

Em seguida, abra uma nova query Sql e digite o seguinte comando para criar um novo banco:

`create database bdpessoas;`

Assim será criado um novo banco de nome "bdpessoas";
Agora crie a tabela pelo comando:

`use bdpessoas;`

`create table pessoas(
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
);`

Dessa forma, estaremos informando que usamos o banco bdpessoas e criando uma tabela "pessoas" nele.

* Por padrão o MySql faz conexões em localhost:3306
##
### Configuração no Eclipse:

Após a configuração do banco de dados no MySql Workbench, basta abrir o projeto no Eclipse e executá-lo normalmente.

Para visualizar o projeto executado, basta abrir seu navegador e digitar o link "http://localhost:8080", que carregará o projeto.

### Espero ter Ajudado :)





