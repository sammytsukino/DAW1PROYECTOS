CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

CREATE TABLE libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200),
    genero VARCHAR(50),
    id_autor INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE socio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE prestamo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_libro INT,
    id_socio INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (id_libro) REFERENCES libro(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_socio) REFERENCES socio(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
