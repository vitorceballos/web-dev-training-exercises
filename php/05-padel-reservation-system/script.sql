-- Creamos la base de datos
CREATE DATABASE IF NOT EXISTS padel;
USE padel;

-- Creamos la tabla de usuarios
CREATE TABLE USUARIO (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    tipo INT NOT NULL CHECK (tipo IN (0, 1))
);

-- Creamos la tabla de pistas
CREATE TABLE PISTA (
    id_pista INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Creamos la tabla de reservas
CREATE TABLE RESERVA (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    usuario INT NOT NULL,
    pista INT NOT NULL,
    turno INT NOT NULL,
    FOREIGN KEY (usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (pista) REFERENCES PISTA(id_pista)
);

-- Insertamos un usuario administrador
INSERT INTO USUARIO (nombre, pass, tipo)
VALUES ('admin', 'admin123', 0); 