
-- ================================
-- Sistema de Biblioteca con Objetos
-- Oracle SQL Developer (21c XE)
-- ================================

-- Tipos de objeto

CREATE OR REPLACE TYPE tipo_autor AS OBJECT (
  id_autor NUMBER,
  nombre   VARCHAR2(100),
  nacionalidad VARCHAR2(50)
);
/

CREATE OR REPLACE TYPE tipo_prestamo AS OBJECT (
  id_prestamo NUMBER,
  fecha_prestamo DATE,
  socio        tipo_socio,
  libro        tipo_libro
);
/

-- Tablas basadas en objetos

CREATE TABLE autores_obj OF tipo_autor (
  PRIMARY KEY (id_autor)
);

CREATE TABLE prestamos_obj OF tipo_prestamo (
  PRIMARY KEY (id_prestamo)
);

