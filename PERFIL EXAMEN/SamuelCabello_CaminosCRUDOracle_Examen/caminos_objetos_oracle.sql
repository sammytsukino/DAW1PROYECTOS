-- Script Oracle para sistema de empresa de caminos

CREATE OR REPLACE TYPE tipo_camino AS OBJECT (
  id_camino NUMBER,
  nombre VARCHAR2(100),
  longitud NUMBER,
  tipo_terreno VARCHAR2(50)
);
/

CREATE OR REPLACE TYPE tipo_trabajador AS OBJECT (
  id_trabajador NUMBER,
  nombre VARCHAR2(100),
  especialidad VARCHAR2(50)
);
/

CREATE OR REPLACE TYPE tipo_proyecto AS OBJECT (
  id_proyecto NUMBER,
  nombre VARCHAR2(100),
  fecha_inicio DATE,
  camino tipo_camino
);
/

CREATE OR REPLACE TYPE tipo_asignacion AS OBJECT (
  id_asignacion NUMBER,
  fecha DATE,
  trabajador tipo_trabajador,
  proyecto tipo_proyecto
);
/

CREATE TABLE caminos_obj OF tipo_camino (
  PRIMARY KEY (id_camino)
);

CREATE TABLE trabajadores_obj OF tipo_trabajador (
  PRIMARY KEY (id_trabajador)
);

CREATE TABLE proyectos_obj OF tipo_proyecto (
  PRIMARY KEY (id_proyecto)
);

CREATE TABLE asignaciones_obj OF tipo_asignacion (
  PRIMARY KEY (id_asignacion)
);
