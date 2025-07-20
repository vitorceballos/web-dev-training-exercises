-- Creamos la base de datos
CREATE DATABASE IF NOT EXISTS M07_DWES_T07;

USE M07_DWES_T07;

CREATE TABLE locales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    coordenadas VARCHAR(50) NOT NULL,
    poblacion VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

-- Insertamos datos
INSERT INTO locales (nombre, coordenadas, poblacion, tipo) VALUES
('Trattoria Pulcinella', '40.42483635457782,-3.696563239033514', 'Madrid', 'Restaurante'),
('Casa Macareno', '40.4262872137906,-3.704722276078898', 'Madrid', 'Restaurante'),
('Pez Tortilla', '40.41526838494245,-3.702396490643196', 'Madrid', 'Bar'),
('SALA EQUIS', '40.41272134395964,-3.7057891915822774', 'Madrid', 'Bar'),
('Teatro Kapital', '40.41001563197516,-3.6929111289951395', 'Madrid', 'Discoteca'),
('Panda Club', '40.44841640453846,-3.696019668303124', 'Madrid', 'Discoteca');