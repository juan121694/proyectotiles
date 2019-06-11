DROP TABLE IF EXISTS inversiones;

DROP TABLE IF EXISTS movimientos;

DROP TABLE IF EXISTS clientes;

DROP TABLE IF EXISTS login;

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
INSERT INTO movimientos (concepto,fecha,cantidad,tipo,usuario) VALUES('Mercado','1994-2-1',1324,'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Grocery', '2018-10-07', 999865, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Clothing', '2019-10-07', 221831, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Games', '2019-11-02', 124386, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Jewelery', '2019-02-16', 684475, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Health', '2018-06-22', 589288, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Jewelery', '2018-12-01', 792070, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Games', '2019-02-27', 144509, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Jewelery', '2019-10-02', 538517, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Sports', '2018-07-28', 958831, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Clothing', '2019-04-03', 695226, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Kids', '2019-12-24', 747202, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Garden', '2020-01-20', 601024, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Shoes', '2019-07-13', 650807, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Industrial', '2019-11-30', 122065, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Grocery', '2018-11-15', 295296, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Toys', '2018-08-24', 89941, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Baby', '2019-04-04', 372750, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Outdoors', '2018-06-12', 159191, 'Abono', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Industrial', '2018-09-24', 817306, 'Cargo', 'juan');
insert into movimientos (concepto, fecha, cantidad, tipo, usuario) values ('Kids', '2019-11-08', 794857, 'Abono', 'juan');

CREATE TABLE inversiones (
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  concepto varchar(100) NOT NULL,
  fecha date NOT NULL,
  valor int NOT NULL,
  tipo varchar(50) NOT NULL,
  usuario varchar(250) NOT NULL,
  FOREIGN KEY(usuario) REFERENCES login(usuario)
);
INSERT INTO inversiones (concepto,fecha,valor,tipo,usuario) VALUES('Mercado','1994-1-1',1324,'Abono', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Restaurants', '2018-07-28', 415643, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Oilfield Services/Equipment', '2019-09-23', 464850, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Biotechnology: Laboratory Analytical Instruments', '2018-06-04', 516397, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('n/a', '2020-02-15', 274735, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('n/a', '2019-02-04', 971529, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Major Pharmaceuticals', '2019-03-28', 243258, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Real Estate Investment Trusts', '2018-08-27', 412636, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Major Banks', '2018-09-23', 922156, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Medical Specialities', '2019-03-27', 995632, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Biotechnology: Biological Products (No Diagnostic Substances)', '2019-07-04', 907337, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Real Estate Investment Trusts', '2020-01-10', 687013, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Agricultural Chemicals', '2020-02-16', 260390, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('n/a', '2019-07-16', 406461, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Biotechnology: Commercial Physical & Biological Resarch', '2020-01-05', 70366, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Industrial Specialties', '2020-02-02', 838584, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Major Banks', '2019-09-17', 646872, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Real Estate Investment Trusts', '2018-07-13', 749139, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Oilfield Services/Equipment', '2019-01-08', 507064, 'Arriesgada', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Major Pharmaceuticals', '2018-06-25', 441354, 'Segura', 'juan');
insert into inversiones (concepto, fecha, valor, tipo, usuario) values ('Other Consumer Services', '2018-10-19', 512238, 'Segura', 'juan');


