CREATE TYPE Endereco (
    rua varchar(50),
    numero integer,
    bairro varchar(30),
    cidade varchar(30)
);

CREATE TYPE Usuario (
    nome varchar(50),
    endereco Endereco,
    email varchar(30),
    senha varchar(30),
    telefone varchar(15)
);

CREATE TABLE IF NOT EXISTS TB_Aluno (
    id serial PRIMARY KEY,
    usuario Usuario,
    idExames integer,
    idFichaAnamnese integer,
    idDieta integer, 
    idTreino integer,
);

CREATE TABLE IF NOT EXISTS TB_Personal (
    cref integer PRIMARY KEY,
    usuario Usuario
);

CREATE TABLE IF NOT EXISTS TB_Nutricionista (
    crm integer PRIMARY KEY,
    usuario Usuario
);

CREATE TABLE IF NOT EXISTS TB_Exercicio (
    idExercicio serial PRIMARY KEY,
    nome varchar(30),
    membro varchar(30),
    grupo char,
    idAutor integer
);