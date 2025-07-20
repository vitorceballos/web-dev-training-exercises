CREATE DATABASE bd_alumnos;
USE bd_alumnos;

CREATE TABLE alumnos (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT,
    curso VARCHAR(50),
    media DOUBLE
);

USE bd_alumnos;
ALTER TABLE alumnos
MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;

SELECT * FROM alumnos;