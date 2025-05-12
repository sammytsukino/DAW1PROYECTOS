-- Creamos objeto Teléfono

CREATE OR REPLACE TYPE telefono_obj AS OBJECT (
tipo VARCHAR2(20),
numero VARCHAR2(10)
);
/

-- Creamos tipo Lista de Teléfonos

CREATE OR REPLACE TYPE lista_telefonos AS TABLE OF telefono_obj;
/

-- Creamos Objeto Cliente
CREATE OR REPLACE TYPE cliente_obj AS OBJECT (
id_cliente NUMBER,
nombre VARCHAR2(30),
telefonos lista_telefonos
);
/

-- Creamos una tabla basada en cliente_obj
CREATE TABLE clientes_tabla of cliente_obj
NESTED TABLE telefonos STORE AS telefonos_tabla;
/


-- Eliminamos primero la tabla
DROP TABLE clientes_tabla;

-- Eliminamos los tipos
DROP TYPE cliente_obj;
DROP TYPE lista_telefonos;
DROP TYPE telefono_obj;

-- Insertar dentro de la tabla clientes

INSERT INTO clientes_tabla VALUES (
cliente_obj(
1, 
'Samuel Cabello Gallego', 
lista_telefonos (
    telefono_obj('Movil', '653085610'), 
    telefono_obj('Casa', '954692024')
    )
    )
    );
    /

-- SELECT * FROM -- (Nombrar siempre las acciones)
SELECT VALUE(clientetabla)
FROM clientes_tabla clientetabla;
/

-- UPDATE --
UPDATE clientes_tabla clientetabla
SET clientetabla.id_cliente=2
WHERE clientetabla.nombre= 'Pepita perez';
/

-- DELETE FROM --
DELETE FROM clientes_tabla clientetabla
WHERE clientetabla.id_cliente=2;
/

-- SELECT FROM TELEFONOS--
SELECT tt.tipo, tt.numero
FROM clientes_tabla tc,
    TABLE(tc.telefonos) tt;
/

-- SELECT NOMBRE FROM --
SELECT tc.nombre
FROM clientes_tabla tc;
/

----------------------------------------------------------

-- Creamos el objeto curso --
CREATE OR REPLACE TYPE curso AS OBJECT (
nombre VARCHAR2(26),
nota NUMBER(2,1)
);
/

-- Lista de cursos --
CREATE OR REPLACE TYPE lista_cursos AS TABLE OF curso;
/

-- Creamos el objeto estudiante --
CREATE OR REPLACE TYPE estudiante AS OBJECT (
id_estudiante NUMBER,
nombre VARCHAR2(26),
cursos lista_cursos
);
/

-- Tabla de estudiantes --

CREATE TABLE estudiantes_tabla OF estudiante
NESTED TABLE cursos STORE AS cursos_tabla;
/

-- Selecciono nombres de estudiantes y nombres y notas de cursos --

SELECT te.nombre, tc.nombre, tc.nota
FROM estudiantes_tabla te,
    TABLE(te.cursos) tc;
/

-- Selecciono los nombres de todo --

SELECT te.nombre
FROM estudiantes_tabla te
/

-- Selecciono los nombres y el ID de los estudiantes --

SELECT te.nombre, te.id_estudiante
FROM estudiantes_tabla te;
/

-- Updateamos el nombre del estudiante con ID 2 --

UPDATE estudiantes_tabla te
SET te.nombre = 'Maripili Gómez'
WHERE te.id_estudiante = 2;
/

------------------------------------------------

CREATE OR REPLACE TYPE proyecto AS OBJECT (
id_proyecto NUMBER,
nombre_proyecto VARCHAR2(26)
);
/

CREATE OR REPLACE TYPE lista_proyectos AS TABLE OF proyecto;
/

CREATE OR REPLACE TYPE empleado AS OBJECT (
id_empleado NUMBER,
nombre_empleado VARCHAR2(26),
rol VARCHAR2(26),
proyectos lista_proyectos
);
/

CREATE TABLE empleados_tabla of empleado
NESTED TABLE proyectos STORE AS proyectos_tabla;
/



------- Creamos objeto ------------

CREATE OR REPLACE TYPE direccion_obj AS OBJECT (
calle VARCHAR2(20),
ciudad VARCHAR2(20),
codigo_postal VARCHAR2(20)
);
/

---- Creamos tabla simple con objeto ------

CREATE TABLE empleados(
id_empleado NUMBER PRIMARY KEY,
nombre VARCHAR2(20),
direccion direccion_obj
);



