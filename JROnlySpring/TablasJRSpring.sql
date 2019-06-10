DROP TABLE inversiones;

DROP TABLE movimientos;

DROP TABLE clientes;

DROP TABLE login;

CREATE TABLE login (
  usuario varchar(250) PRIMARY KEY,
  password varchar(250) NOT NULL
);

INSERT INTO login (usuario, password) VALUES('juan', '1');

CREATE TABLE clientes (
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  app varchar(50) NOT NULL,
  apm varchar(50) NOT NULL,
  fecha_nacimiento date NOT NULL,
  sexo char(1) DEFAULT NULL,
  usuario varchar(250) NOT NULL,
  FOREIGN KEY(usuario) REFERENCES login(usuario)
);

CREATE TABLE movimientos (
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  concepto varchar(100) NOT NULL,
  fecha date NOT NULL,
  cantidad int NOT NULL,
  tipo varchar(50) NOT NULL,
  usuario varchar(250) NOT NULL,
  FOREIGN KEY(usuario) REFERENCES login(usuario)
);

CREATE TABLE inversiones (
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  concepto varchar(100) NOT NULL,
  fechaInicio date NOT NULL,
  valor int NOT NULL,
  tipo varchar(50) NOT NULL,
  usuario varchar(250) NOT NULL,
  FOREIGN KEY(usuario) REFERENCES login(usuario)
);
