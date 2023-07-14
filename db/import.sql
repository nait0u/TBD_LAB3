INSERT INTO emergencia (id_institucion, nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)
VALUES
    (2,'Incendio', 'Incendio en un edificio residencial', '2023-06-10', 'Equipo de bomberos', 'Ambulancia', -79.8684,-33.7122),
    (2,'Fuga de gas', 'Fuga de gas en una planta industrial', '2023-06-09', 'Equipo de bomberos', 'Equipo de seguridad', -70.51496,-33.35781),
    (3,'Accidente de trafico', 'Colision multiple en una autopista', '2023-06-11', 'Equipo de rescate', 'Ambulancia', -70.5022,-33.1891),
    (4,'Inundacion', 'Inundacion en un vecindario', '2023-06-08', 'Equipo de rescate', 'Equipo de evacuacion', -69.619,-17.694),
    (3,'Derrumbe', 'Derrumbe en una construccion', '2023-06-07', 'Equipo de rescate', 'Equipo de seguridad', -70.2844,-33.5822),
    (1,'Incendio forestal', 'Incendio en un bosque cercano', '2023-06-10', 'Equipo de bomberos', 'Equipo de rescate', -71.3279,-33.9139),
    (5,'Accidente quimico', 'Derrame de productos quimicos en una fabrica', '2023-06-11', 'Equipo de seguridad', 'Equipo de rescate', -73.9248,-38.3771),
    (4,'Terremoto', 'Terremoto de magnitud 7.5 en la region', '2023-06-09', 'Equipo de rescate', 'Equipo de evacuacion', -71.5632,-39.2627),
    (3,'Avalancha', 'Avalancha en una zona montanosa', '2023-06-12', 'Equipo de rescate', 'Helicoptero', -71.995,-37.076),
    (2,'Explosion', 'Explosion en un edificio comercial', '2023-06-13', 'Equipo de bomberos', 'Equipo de seguridad', -109.5043,-27.0906);

INSERT INTO voluntario (correo, usuario, nombre, pass, atributos)
VALUES
    ('voluntario1@example.com', 'voluntario1', 'Juan Perez', 'password1', 'Rescate en emergencias'),
    ('voluntario2@example.com', 'voluntario2', 'Maria Lopez', 'password2', 'Primeros auxilios'),
    ('voluntario3@example.com', 'voluntario3', 'Carlos Rodriguez', 'password3', 'Ayuda humanitaria'),
    ('voluntario4@example.com', 'voluntario4', 'Ana Gomez', 'password4', 'Evacuacion de personas'),
    ('voluntario5@example.com', 'voluntario5', 'Pedro Martinez', 'password5', 'Comunicacion y logistica'),
    ('voluntario6@example.com', 'voluntario6', 'Laura Torres', 'password6', 'Apoyo psicologico'),
    ('voluntario7@example.com', 'voluntario7', 'Javier Ramirez', 'password7', 'Distribucion de suministros'),
    ('voluntario8@example.com', 'voluntario8', 'Sofia Herrera', 'password8', 'Asistencia medica'),
    ('voluntario9@example.com', 'voluntario9', 'Diego Vargas', 'password9', 'Coordinacion de equipos'),
    ('voluntario10@example.com', 'voluntario10', 'Valentina Castro', 'password10', 'Rescate acuatico');

INSERT INTO tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude)
VALUES
    (1, 'Control de fuego', 'Controlar y extinguir el incendio', '2023-06-10', 'Equipo de bomberos, Mangueras, Extintores', -79.8684,-33.7122),
    (2, 'Reparacion de fuga', 'Reparar la fuga de gas en la planta industrial', '2023-06-09', 'Equipo de reparacion, Suministros de seguridad', -70.51496,-33.35781),
    (3, 'Rescate en accidente', 'Rescatar a las personas atrapadas en el accidente de trafico', '2023-06-11', 'Equipo de rescate, Equipo de extraccion', -70.5022,-33.1891),
    (4, 'Evacuacion por inundacion', 'Realizar la evacuacion de las personas afectadas por la inundacion', '2023-06-08', 'Equipo de rescate, Botes salvavidas', -69.619,-17.694),
    (5, 'Busqueda y rescate', 'Buscar y rescatar a las personas atrapadas en el derrumbe', '2023-06-07', 'Equipo de busqueda, Equipos de seguridad', -70.2844,-33.5822),
    (6, 'Control de incendio forestal', 'Controlar y extinguir el incendio en el bosque cercano', '2023-06-10', 'Equipo de bomberos, Mangueras, Helicopteros', -71.3279,-33.9139),
    (2, 'Limpieza de derrame quimico', 'Limpiar el derrame de productos quimicos en la fabrica', '2023-06-11', 'Equipo de limpieza, Materiales de contencion', -70.51496,-33.35781),
    (8, 'Busqueda y rescate tras terremoto', 'Buscar y rescatar a las personas atrapadas tras el terremoto', '2023-06-09', 'Equipo de rescate, Perros de busqueda', -71.5632,-39.2627),
    (9, 'Rescate en avalancha', 'Rescatar a las personas atrapadas en la zona montanosa por una avalancha', '2023-06-12', 'Equipo de rescate, Equipos de supervivencia', -71.995,-37.076),
    (10, 'Investigacion de explosion', 'Investigar la causa de la explosion en el edificio comercial', '2023-06-13', 'Equipo de investigacion, Equipos de seguridad', -109.5043,-27.0906),
    (4, 'Evacuacion por inundacion costera', 'Realizar la evacuacion de las personas afectadas por la inundacion costera', '2023-06-14', 'Equipo de rescate, Botes salvavidas', -69.619,-17.694),
    (9, 'Rescate en deslizamiento de tierra', 'Rescatar a las personas atrapadas en el deslizamiento de tierra en la zona residencial', '2023-06-10', 'Equipo de rescate, Equipos de seguridad', -73.997, 40.723),
    (1, 'Evacuacion de edificio', 'Realizar la evacuacion del edificio afectado por el incendio', '2023-06-10', 'Equipo de rescate, Botes salvavidas', -79.8684,-33.7122),
    (1, 'Investigacion de causas', 'Realizar la investigacion de las causas del incendio', '2023-06-11', 'Equipo de investigacion, Equipos de seguridad', -79.8684,-33.7122),
    (2, 'Reparacion de equipos', 'Reparar los equipos afectados por la fuga de gas', '2023-06-12', 'Equipo de reparacion, Suministros de seguridad', -70.51496,-33.35781),
    (2, 'Inspeccion de seguridad', 'Realizar una inspeccion de seguridad en la planta industrial', '2023-06-13', 'Equipo de inspeccion, Equipos de seguridad', -70.51496,-33.35781),
    (3, 'Rescate de heridos', 'Rescatar y brindar primeros auxilios a los heridos en el accidente de trafico', '2023-06-12', 'Equipo de rescate, Equipo medico', -70.5022,-33.1891),
    (3, 'Limpieza de via', 'Realizar la limpieza de la via afectada por el accidente', '2023-06-13', 'Equipo de limpieza, Maquinaria de construccion', -70.5022,-33.1891),
    (4, 'Reubicacion de afectados', 'Reubicar a las personas afectadas por la inundacion en refugios temporales', '2023-06-09', 'Equipo de rescate, Vehiculos de transporte', -69.619,-17.694),
    (4, 'Reparacion de infraestructura', 'Reparar la infraestructura dañada por la inundacion', '2023-06-10', 'Equipo de reparacion, Herramientas de construccion',-69.619,-17.694),
    (5, 'Busqueda y rescate en estructuras colapsadas', 'Buscar y rescatar a las personas atrapadas en las estructuras colapsadas debido al derrumbe', '2023-06-11', 'Equipo de búsqueda, Equipos de seguridad', -70.2844,-33.5822),
    (5, 'Remocion de escombros', 'Realizar la remocion de escombros y asegurar la zona del derrumbe', '2023-06-12', 'Equipo de limpieza, Maquinaria de construccion', -70.2844,-33.5822);

insert into estado (nombre) values 
    ('Asignada'),
    ('Rechazada'),
    ('Aceptada'),
    ('Finalizada');


INSERT INTO habilidad (nombre)
VALUES
    ('Programacion'),
    ('Diseño grafico'),
    ('Gestion de proyectos'),
    ('Comunicacion efectiva'),
    ('Resolucion de problemas'),
    ('Trabajo en equipo'),
    ('Creatividad'),
    ('Analisis de datos'),
    ('Negociacion'),
    ('Liderazgo'),
    ('Primeros auxilios'),
    ('Manejo de situaciones de crisis'),
    ('Evacuacion de emergencia'),
    ('RCP (Reanimacion Cardiopulmonar)'),
    ('Manejo de extintores'),
    ('Rescate acuático'),
    ('Manejo de radio de comunicación'),
    ('Supervivencia en condiciones extremas'),
    ('Manejo de equipos de rescate'),
    ('Coordinación de operaciones de emergencia');

INSERT INTO institucion (nombre, usuario, pass, correo, numero)
VALUES
    ('Cruz Roja', 'cruzroja', 'cruzroja123', 'contacto@cruzroja.org', '1234567890'),
    ('Bomberos Municipales', 'bomberos', 'bomberos123', 'info@bomberosmunicipales.org', '0987654321'),
    ('Protección Civil', 'proteccioncivil', 'pcivil2023', 'contacto@proteccioncivil.org', '9876543210'),
    ('Cuerpo de Rescate', 'rescate', 'rescatepass', 'info@rescate.org', '5678901234'),
    ('Hospital General', 'hospital', 'hospital123', 'contacto@hospitalgeneral.org', '0123456789');

INSERT INTO ranking (porcentaje, id_tarea, id_voluntario)
VALUES
    (89.3, 6, 6),
    (78.9, 7, 7),
    (92.1, 8, 8),
    (83.4, 9, 9),
    (95.2, 10, 10),
    (86.7, 11, 1),
    (90.5, 12, 2),
    (77.8, 13, 3),
    (93.9, 14, 4),
    (81.6, 15, 5),
    (88.2, 16, 6),
    (79.5, 17, 7),
    (91.7, 18, 8),
    (82.3, 19, 9),
    (94.8, 20, 10),
    (85.9, 6, 1),
    (89.6, 7, 2),
    (76.3, 8, 3),
    (92.4, 9, 4),
    (80.2, 10, 5),
    (87.4, 11, 6),
    (81.9, 12, 7),
    (93.5, 13, 8),
    (84.6, 14, 9),
    (96.1, 15, 10);

INSERT INTO emergencia_habilidad (id_emergencia, id_habilidad)
VALUES
    (5, 11),
    (2, 12),
    (8, 13),
    (3, 14),
    (7, 15),
    (4, 16),
    (10, 17),
    (6, 18),
    (1, 19),
    (9, 20),
    (7, 1),
    (4, 2),
    (6, 3),
    (9, 4),
    (2, 5);

INSERT INTO estado_tarea (id_estado, id_tarea)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (1, 5),
    (2, 6),
    (3, 7),
    (4, 8),
    (1, 9),
    (2, 10),
    (3, 11),
    (4, 12),
    (1, 13),
    (2, 14),
    (3, 15),
    (4, 16),
    (1, 17),
    (2, 18),
    (3, 19),
    (4, 20);

-- Generar datos aleatorios para la tabla tarea_habilidad
INSERT INTO tarea_habilidad (id_tarea, id_habilidad)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (11, 11),
    (12, 12),
    (13, 13),
    (14, 14),
    (15, 15),
    (16, 16),
    (17, 17),
    (18, 18),
    (19, 19),
    (20, 20);


INSERT INTO voluntario_habilidad (id_voluntario, id_habilidad)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (1, 11),
    (2, 12),
    (3, 13),
    (4, 14),
    (5, 15),
    (6, 16),
    (7, 17),
    (8, 18),
    (9, 19),
    (10, 20);





