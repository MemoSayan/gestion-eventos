CREATE TABLE ciudad (
                        codigo_ciudad BIGINT PRIMARY KEY AUTO_INCREMENT,
                        descripcion_ciudad VARCHAR(100) NOT NULL
);

CREATE TABLE persona (
                         id_persona BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nombre_persona VARCHAR(50) NOT NULL,
                         apellido_persona VARCHAR(50) NOT NULL,
                         cedula_persona VARCHAR(20) NOT NULL UNIQUE,
                         direccion_persona VARCHAR(100),
                         telefono_persona VARCHAR(20),
                         codigo_ciudad BIGINT NOT NULL,
                         CONSTRAINT fk_ciudad_persona FOREIGN KEY (codigo_ciudad) REFERENCES ciudad(codigo_ciudad)
);

CREATE TABLE evento (
                        codigo_evento BIGINT PRIMARY KEY AUTO_INCREMENT,
                        descripcion_evento VARCHAR(100) NOT NULL,
                        codigo_ciudad BIGINT NOT NULL,
                        CONSTRAINT fk_ciudad_evento FOREIGN KEY (codigo_ciudad) REFERENCES ciudad(codigo_ciudad)
);

CREATE TABLE asistencia (
                            id_asistencia BIGINT PRIMARY KEY AUTO_INCREMENT,
                            codigo_evento BIGINT NOT NULL,
                            id_persona BIGINT NOT NULL,
                            asistir BOOLEAN NOT NULL,
                            CONSTRAINT fk_evento FOREIGN KEY (codigo_evento) REFERENCES evento(codigo_evento),
                            CONSTRAINT fk_persona FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

CREATE TABLE usuario (
                         id_usuario BIGINT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(50) NOT NULL UNIQUE,
                         password VARCHAR(100) NOT NULL
);