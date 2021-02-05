DROP table if EXISTS USUARIO;

CREATE TABLE IF NOT EXISTS usuario
(
id INT GENERATED ALWAYS AS IDENTITY,
nombres character varying(50) NOT NULL,
apellidos character varying(50) NOT NULL,
celular character varying(20) NOT NULL,
direccion character varying(250) NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO usuario(nombres, apellidos, celular, direccion)
VALUES('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto'),
('Jefersson', 'Gálvez', '12931892381092', 'cra 65A # 75-849, apto');