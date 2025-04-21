
CREATE DATABASE IF NOT EXISTS libreria;
USE libreria;

CREATE TABLE genero (
    id_genero INT PRIMARY KEY,
    nombre_genero VARCHAR(50)
);

CREATE TABLE autor (
    id_autor INT PRIMARY KEY,
    nombre_autor VARCHAR(100),
    nacionalidad VARCHAR(50)
);

CREATE TABLE libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(200),
    anio_publicacion INT,
    id_autor INT,
    id_genero INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero)
);

CREATE TABLE prestamo (
    id_libro INT,
    fecha_prestamo DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

