CREATE DATABASE projeto_crud;

CREATE TABLE usuario(
  id int NOT NULL auto_increment primary key,
  nome varchar(70),
  telefone char(11),
  email varchar(40) UNIQUE,
  senha varchar(32) 
) 

CREATE TABLE telefone(
  id int NOT NULL auto_increment primary key,
  ddd int,
  numero varchar(9),
  tipo varchar(30)
)