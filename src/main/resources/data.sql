-- Ciudades
INSERT INTO ciudad (descripcion_ciudad) VALUES ('Asunción');
INSERT INTO ciudad (descripcion_ciudad) VALUES ('Encarnación');

-- Personas
INSERT INTO persona ( nombre_persona, apellido_persona, cedula_persona, direccion_persona, telefono_persona, codigo_ciudad)
VALUES ( 'Guillermo', 'De la Cruz', '1234567', 'Av. Principal 123', '0981123456', 1);

-- Eventos
INSERT INTO evento ( descripcion_evento, codigo_ciudad)
VALUES ( 'Conferencia de Tecnología', 1);

-- Asistencias
-- Después (deja que H2 use el AUTO_INCREMENT)
INSERT INTO asistencia (codigo_evento, id_persona, asistir)
VALUES (1, 1, TRUE);

-- Usuarios
INSERT INTO usuario (username, password) VALUES ('admin', 'admin123');
