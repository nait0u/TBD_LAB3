BEGIN;

DROP TABLE IF EXISTS regiones;
CREATE TABLE IF NOT EXISTS regiones (id serial primary key, id_region serial, nom_reg text, geom geometry(MultiPolygon, 4326));

DROP TABLE IF EXISTS emergencia;
CREATE TABLE IF NOT EXISTS emergencia (id serial primary key, id_institucion serial, nombre text, descripcion text unique
                                    , fecha date, reqs_grupales text, reqs_individuales text,longitude double precision, latitude double precision);

DROP TABLE IF EXISTS voluntario;
CREATE TABLE IF NOT EXISTS voluntario (id serial primary key, correo text unique, usuario text, nombre text, pass text, atributos text);

DROP TABLE IF EXISTS tarea;
CREATE TABLE IF NOT EXISTS tarea (id serial primary key, id_emergencia serial, nombre text, descripcion text, fecha date, 
                                requerimientos text, longitude double precision, latitude double precision);

DROP TABLE IF EXISTS estado;
CREATE TABLE IF NOT EXISTS estado (id serial primary key, nombre text);

DROP TABLE IF EXISTS habilidad;
CREATE TABLE IF NOT EXISTS habilidad (id serial primary key, nombre text);

DROP TABLE IF EXISTS institucion;
CREATE TABLE IF NOT EXISTS institucion (id serial primary key, nombre text unique, usuario text, pass text, correo text unique, numero text);

DROP TABLE IF EXISTS ranking;
CREATE TABLE IF NOT EXISTS ranking (id serial primary key, porcentaje real, id_tarea serial, id_voluntario serial);

DROP TABLE IF EXISTS emergencia_habilidad;
CREATE TABLE IF NOT EXISTS emergencia_habilidad (id serial primary key, id_emergencia serial, id_habilidad serial);

DROP TABLE IF EXISTS estado_tarea;
CREATE TABLE IF NOT EXISTS estado_tarea (id serial primary key, id_estado serial, id_tarea serial);

DROP TABLE IF EXISTS tarea_habilidad;
CREATE TABLE IF NOT EXISTS tarea_habilidad (id serial primary key, id_tarea serial, id_habilidad serial);

DROP TABLE IF EXISTS voluntario_habilidad;
CREATE TABLE IF NOT EXISTS voluntario_habilidad (id serial primary key, id_voluntario serial, id_habilidad serial);

DROP TABLE IF EXISTS audit_log;
CREATE TABLE IF NOT EXISTS audit_log  (id serial PRIMARY KEY, table_name text, operation text, usuario text, timestamp timestamp, query text);

END;