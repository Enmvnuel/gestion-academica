DROP DATABASE IF EXISTS bd_gestionacademica;
CREATE DATABASE bd_gestionacademica;
USE bd_gestionacademica;

-- ==========================================
-- 1. CREACION DE TABLAS
-- ==========================================

CREATE TABLE tb_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL -- Admin, Docente, Estudiante
);

CREATE TABLE tb_estudiante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo VARCHAR(100),
    telefono VARCHAR(15),
    usuario_id INT UNIQUE,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_docente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100),
    usuario_id INT UNIQUE,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    ciclo VARCHAR(20) NOT NULL
);

CREATE TABLE tb_matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_registro DATE NOT NULL,
    estado VARCHAR(20) NOT NULL, -- Registrada, Anulada
    estudiante_id INT NOT NULL,
    FOREIGN KEY (estudiante_id) REFERENCES tb_estudiante(id)
);

CREATE TABLE tb_detalle_matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula_id INT NOT NULL,
    curso_id INT NOT NULL,
    FOREIGN KEY (matricula_id) REFERENCES tb_matricula(id),
    FOREIGN KEY (curso_id) REFERENCES tb_curso(id)
);

CREATE TABLE tb_nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    calificacion DECIMAL(4,2),
    estudiante_id INT NOT NULL,
    curso_id INT NOT NULL,
    FOREIGN KEY (estudiante_id) REFERENCES tb_estudiante(id),
    FOREIGN KEY (curso_id) REFERENCES tb_curso(id)
);

-- ==========================================
-- 2. INSERCION DE DATOS DE PRUEBA (SEED DATA)
-- ==========================================

-- 2.1 usuarios para el kogin
-- admin
INSERT INTO tb_usuario (username, password, rol) VALUES ('admin', 'admin123', 'Admin');
-- docente
INSERT INTO tb_usuario (username, password, rol) VALUES ('profe', 'profe123', 'Docente');
-- estudiantes
INSERT INTO tb_usuario (username, password, rol) VALUES ('jperez', 'alumno123', 'Estudiante');
INSERT INTO tb_usuario (username, password, rol) VALUES ('mgomez', 'alumno123', 'Estudiante');

-- 2.2 docentes (vinculados a su usuario correspondiente, en este caso el ID 2)
INSERT INTO tb_docente (dni, nombres, apellidos, especialidad, usuario_id) 
VALUES ('09876543', 'David Elias', 'Espinoza Sandoval', 'Ingeniería de Software', 2);

-- 2.3 estudiantes (vinculados a los usuarios ID 3 y 4)
INSERT INTO tb_estudiante (dni, nombres, apellidos, correo, telefono, usuario_id) 
VALUES ('71234567', 'Juan Jesus', 'Perez', 'jperez@cibertec.edu.pe', '987654321', 3);

INSERT INTO tb_estudiante (dni, nombres, apellidos, correo, telefono, usuario_id) 
VALUES ('72345678', 'Maria Fernanda', 'Gomez', 'mgomez@cibertec.edu.pe', '912345678', 4);

-- 2.4 Cursos
INSERT INTO tb_curso (nombre, creditos, ciclo) VALUES ('Lenguaje de Programación II', 4, 'Ciclo III');
INSERT INTO tb_curso (nombre, creditos, ciclo) VALUES ('Base de Datos Avanzada', 3, 'Ciclo III');
INSERT INTO tb_curso (nombre, creditos, ciclo) VALUES ('Desarrollo Web Integrado', 4, 'Ciclo IV');
INSERT INTO tb_curso (nombre, creditos, ciclo) VALUES ('Ingeniería de Requerimientos', 3, 'Ciclo III');

-- 2.5 matriculas de prueba
-- Matricula de Juan (ID 1)
INSERT INTO tb_matricula (fecha_registro, estado, estudiante_id) VALUES ('2026-02-15', 'Registrada', 1);
-- matricula de Maria (ID 2)
INSERT INTO tb_matricula (fecha_registro, estado, estudiante_id) VALUES ('2026-02-16', 'Registrada', 2);

-- 2.6 detalle de matriculas (cursos a los que están inscritos)
-- Juan lleva LP2 y BD avanzada
INSERT INTO tb_detalle_matricula (matricula_id, curso_id) VALUES (1, 1);
INSERT INTO tb_detalle_matricula (matricula_id, curso_id) VALUES (1, 2);
-- Maria lleva LP2 y desarrollo Web
INSERT INTO tb_detalle_matricula (matricula_id, curso_id) VALUES (2, 1);
INSERT INTO tb_detalle_matricula (matricula_id, curso_id) VALUES (2, 3);

-- 2.7 notas (record academico)
-- notas de Juan
INSERT INTO tb_nota (calificacion, estudiante_id, curso_id) VALUES (18.50, 1, 1);
INSERT INTO tb_nota (calificacion, estudiante_id, curso_id) VALUES (15.00, 1, 2);
-- notas de Maria
INSERT INTO tb_nota (calificacion, estudiante_id, curso_id) VALUES (14.00, 2, 1);
INSERT INTO tb_nota (calificacion, estudiante_id, curso_id) VALUES (19.00, 2, 3);