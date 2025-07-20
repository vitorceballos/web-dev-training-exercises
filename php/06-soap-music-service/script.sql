-- Creamos la base de datos
CREATE DATABASE IF NOT EXISTS musica;

-- Seleccionamos la base de datos
USE musica;

-- Creamos la tabla de géneros
CREATE TABLE GENERO (
    id_genero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Creamos la tabla de grupos
CREATE TABLE GRUPO (
    id_grupo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero INT NOT NULL,
    FOREIGN KEY (genero) REFERENCES GENERO(id_genero)
);

-- Insertamos géneros de ejemplo
INSERT INTO GENERO (nombre) VALUES 
('Blues Rock'), 
('Pop'), 
('Rock'), 
('Reggae'), 
('Reggaeton'), 
('Electronic');

-- Insertamos grupos de ejemplo
INSERT INTO GRUPO (nombre, genero) VALUES 
('John Mayer', 1), 
('Coldplay', 2),      
('Paul Mccartney', 3),   
('Bob Marley', 4),    
('Rosalia', 5),   
('David Guetta', 6);     

-- Se crea un usuario administrador tal y como solicitado en la actividad.
CREATE USER 'admin_musica'@'localhost' IDENTIFIED BY 'admin123';

-- Asignamos todos los privilegios al usuario administrador sobre la base de datos 'musica'
GRANT ALL PRIVILEGES ON musica.* TO 'admin_musica'@'localhost';

-- Aplicamos los cambios de privilegios
FLUSH PRIVILEGES;
