CREATE SCHEMA DynamiClient;
USE reto1;

CREATE TABLE PROYECTO (
   codigo int NOT NULL,
   cliente int NOT NULL,
   objetivo varchar(200) DEFAULT NULL,
   comercial int NOT NULL,
   valor_venta double DEFAULT NULL,
   fecha_venta date NOT NULL,
   inicio date NOT NULL,
   fin date NOT NULL,
   PRIMARY KEY (codigo,cliente,comercial)
 );


INSERT INTO proyecto ( codigo, cliente , objetivo , comercial, valor_venta, fecha_venta, inicio, fin ) VALUES (1, 1, "Puesta en marcha de aplicación móvil de todos los clientes tigo", 5, 600000000.0,"2021/01/01","2021/02/01","2021/08/01" ) ;
INSERT INTO proyecto (codigo, cliente , objetivo , comercial, valor_venta, fecha_venta, inicio, fin ) VALUES (2, 2, "Desarrollo de seguridad de oleoductos",4,900000000.0, "2020/09/15","2020/09/20","2021/03/01") ;
INSERT INTO proyecto (codigo, cliente , objetivo , comercial, valor_venta, fecha_venta, inicio, fin) VALUES (3, 2, "Gestor documental sede Bogotá", 4,850000000.0, "2020/12/15","2020/01/01","2021/09/01" ) ;

CREATE TABLE empleado (  
   codigo int NOT NULL , 
   nombres varchar (200), 
   apellidos varchar (200) , 
   tipo_documento varchar (200), 
   documento varchar (20) ,
   email varchar (100) , 
   telefono varchar (15) , 
   salario double , 
   PRIMARY KEY (codigo)
);
 
INSERT INTO empleado (codigo,nombres , apellidos , tipo_documento, documento, email, telefono, salario ) VALUES ( 1 ,'Carlos' , 'Perez', 'cc', '123456', 'cperez@test.com', '310 555 5555', 4500000 ) ;
INSERT INTO empleado (codigo, nombres , apellidos , tipo_documento, documento, email, telefono, salario ) VALUES (2 , 'Andrea' ,'Herrera', 'ce', '654789', 'aherrera@test.com', '315 666 6666', 4600000 ) ;
INSERT INTO empleado (codigo, nombres , apellidos , tipo_documento, documento, email, telefono, salario ) VALUES ( 3 ,'Pedro', 'Contreras', 'passport', '45123', 'pcontreras@test.com', '310 444 4444', 4300000) ;
INSERT INTO empleado (codigo, nombres , apellidos , tipo_documento, documento, email, telefono, salario ) VALUES (4 , 'Paola', 'Perez', 'cc', '654123', 'pperez@test.com', '314 456 1234', 4200000) ;
INSERT INTO empleado ( codigo,nombres , apellidos , tipo_documento, documento, email, telefono, salario ) VALUES ( 5 ,'Carolina', 'Herrera', 'cc', '789456', 'cherrera@test.com', '456 4478', 4300000 ) ;

CREATE TABLE CLIENTE (  
codigo integer, 
nombre varchar (200), 
nit varchar (15) , 
representante_legal varchar (200) , 
sector_comercial varchar (200) , 
PRIMARY KEY ( codigo )  ) ;

INSERT INTO cliente ( codigo,nombre , nit , representante_legal, sector_comercial) VALUES (1,"Tigo", "900806921", "Juan Cárdenas", "comunicaciones" ) ;
INSERT INTO cliente ( codigo,nombre , nit , representante_legal, sector_comercial ) VALUES (2, "Ecopetrol", "900806922", "Manuela González", "gaseoductos" ) ;

CREATE TABLE ASIGNACION (
 codigo integer,
 empleado integer NOT NULL ,
 rol varchar ( 20 ) ,
 proyecto integer NOT NULL ,
 inicio date NOT NULL ,
 fin date NOT NULL ,
 PRIMARY KEY ( codigo )
 );
 
INSERT INTO asignacion (codigo, empleado , rol , proyecto, inicio, fin) VALUES (1,1, "Gerente",1,"2021/01/05", "2021/08/05" ) ;
INSERT INTO asignacion ( codigo,empleado , rol , proyecto, inicio, fin) VALUES (2, 2, "Gerente",2, "2020/09/25","2021/03/05" ) ;
INSERT INTO asignacion ( codigo, empleado , rol , proyecto, inicio, fin) VALUES (3, 1, "Gerente",3, "2020/12/15", "2021/10/01") ;



