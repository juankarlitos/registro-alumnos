--Insertar Materias

INSERT INTO materias (nombre) VALUES ('Espanol');
INSERT INTO materias (nombre) VALUES ('Matematica');
INSERT INTO materias (nombre) VALUES ('Quimica');

-- Insertar Alumnos

INSERT INTO alumnos (nombre, apellido_paterno, apellido_materno, materia_id) VALUES ('Juan', 'Perez', 'Gomez', 1);
INSERT INTO alumnos (nombre, apellido_paterno, apellido_materno, materia_id) VALUES ('Catalina', 'Inostroza', 'Godoy', 2);

-- Insertar Calificaciones

INSERT INTO calificaciones (alumno_id, materia_id, nota) VALUES (1, 1,6.5);
INSERT INTO calificaciones (alumno_id, materia_id, nota) VALUES (2, 2,7.0);