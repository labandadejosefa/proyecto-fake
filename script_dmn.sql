ALTER table objetoReservable ADD CHECK (tipo IN ('SalaEnsayo', 'Instrumento'));
INSERT INTO	domicilio (calle,altura,localidad,cpostal) VALUES ('Av Belgrano', '520', 'CABA', '1064');
INSERT INTO	domicilio (calle,altura,localidad,cpostal) VALUES ('Chile', '740', 'CABA', '1065');
INSERT INTO usuario (nombre, apellido, email_usuario, password, tel, rol_id) VALUES ('Eddie', 'Vedder', 'eddie@gmail.com', 'pjam2023', '5555', 2);
INSERT INTO sede (nombre_sede, domicilio_id, usuario_id) VALUES ('Sounds', 1, 3);
INSERT INTO objetoReservable (nombre_objeto, precio_hora, precio_min, tipo, sede_id) VALUES ('Contrabajo Segovia 3/4', 3500, 2000, 'Instrumento',1);
INSERT INTO objetoReservable (nombre_objeto, precio_hora, precio_min, tipo, sede_id) VALUES ('Sala A', 4500, 3500, 'SalaEnsayo',1);
ALTER TABLE reserva MODIFY COLUMN fecha_hora timestamp; 
INSERT INTO reserva (usuario_id, objeto_id, fecha_hora, duracion_hs, precio_reserva) VALUES (2,2,now(),1,4500);
INSERT INTO reserva (usuario_id, objeto_id, fecha_hora, duracion_hs, precio_reserva)
VALUES (1, 2, STR_TO_DATE('2023-11-10 10:30:00', '%Y-%m-%d %H:%i:%s'), 2, 9000.0);

INSERT INTO objetoReservable (nombre_objeto, precio_hora, precio_min, tipo, sede_id) VALUES ('Sala B', 4500, 3500, 'hola',1);

