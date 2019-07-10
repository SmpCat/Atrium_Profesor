

CREATE TABLESPACE master
      DATAFILE 'master' size 100 M;

CREATE USER master
      IDENTIFIED BY master
         DEFAULT TABLESPACE master;

grant DBA to master;

REM*************** TABLAS DE CLIENTES *************************

CREATE TABLE  "CLIENTES" 
   (	"CODIGO_CLIENTE" NUMBER(5,0) NOT NULL ENABLE, 
	"NOMBRE_CLIENTE" VARCHAR2(35)NOT NULL,  
	"TIPO_EMPRESA" CHAR(1), 
	"CIF_CLIENTE" VARCHAR2(10), 
	"NIF_CLIENTE" VARCHAR2(10), 
	"NOMBRE_COMERCIAL_CLIENTE" VARCHAR2(40), 
	"FECHA_ALTA_CLIENTE" DATE, 
	"FECHA_BAJA_CLIENTE" DATE, 
	"CALLE_CLIENTE" VARCHAR2(40), 
	"CIUDAD_CLIENTE" VARCHAR2(35), 
	"CP_CLIENTE" VARCHAR2(5), 
	"PROVINCIA_CLIENTE" VARCHAR2(35), 
	"TELEFONO_CLIENTE" VARCHAR2(9), 
	"FAX_CLIENTE" VARCHAR2(9), 
	"EMAIL_CLIENTE" VARCHAR2(35), 
	"CONTADO_CLIENTE" CHAR(1), 
	"CREDITO_CLIENTE" CHAR(1), 
	"CIFRA_VENTAS_CLIENTE" NUMBER(11,2), 
	"BENEFICIOS_CLIENTE" NUMBER(11,2), 
	"PREPAGO_CLIENTE" CHAR(1), 
	"CAPITAL_CLIENTE" NUMBER(11,2), 
	"INMOVILIZADO_CLIENTE" NUMBER(11,2), 
	"PASIVO_CLIENTE" NUMBER(11,2), 
	"ACTIVO_CLIENTE" NUMBER(11,2), 
	"AÑO_BALANCE_CLIENTE" DATE, 
	"LIMITE_CLIENTE" NUMBER(11,2), 
	"PENDIENTE_CLIENTE" NUMBER(11,2), 
	"RESTO_CLIENTE" NUMBER(11,2), 
	"CALLE_ENVIO_CLIENTE" VARCHAR2(40), 
	"CIUDAD_ENVIO_CLIENTE" VARCHAR2(30), 
	"CP_ENVIO_CLIENTE" VARCHAR2(5), 
	"PROVINCIA_ENVIO_CLIENTE" VARCHAR2(35), 
	"TELEFONO_ENVIO_CLIENTE" VARCHAR2(9), 
	"FAX_ENVIO_CLIENTE" VARCHAR2(9), 
	"EMAIL_ENVIO_CLIENTE" VARCHAR2(35), 
	"OBSERVACIONES_CLIENTE" CLOB, 
	"ESTADO_CLIENTE" CHAR(2) NOT NULL ENABLE, 
	 CONSTRAINT "CLIENTE_CODIGO_CLIENTE_PK" PRIMARY KEY ("CODIGO_CLIENTE"),
	CONSTRAINT cliente_valor_ck check (estado_cliente in ('AC','BA','MO'))
   );

CREATE TABLE  "BANCOS" (

	codigo_banco number (10,0),
	"NOMBRE_BANCO" VARCHAR2(40), 
	"DIRECCION_BANCO" VARCHAR2(40), 
	"ENTIDAD_BANCO" NUMBER(4,0), 
	"OFICINA_BANCO" NUMBER(4,0), 
	"DC_BANCO" NUMBER(2,0), 
	"CUENTA_BANCO" NUMBER(10,0), 
	"CODIGO_CLIENTE" NUMBER(5,0) NOT NULL ENABLE, 
	CONSTRAINT bancos_codigo_banco_PK PRIMARY KEY (codigo_banco),
	 CONSTRAINT "BANCOS_COD_CLI_PK" FOREIGN KEY ("CODIGO_CLIENTE")
	  REFERENCES  "CLIENTES" ("CODIGO_CLIENTE")
   );

CREATE TABLE  "FORMAS_PAGO" 
   (	"CODIGO_FORMA_PAGO" NUMBER(5,0), 
	"DESCRIPCION_FORMA_PAGO" VARCHAR2(40),
	ESTADO_FORMA_PAGO CHAR(2),
	NUMERO_PAGOS NUMBER(2),
	NUMERO_DIAS_ENTRE_PAGOS NUMBER(2),
	NUMERO_DIAS_PRIMER_PAGO NUMBER(3),
	FECHA_ALTA_PAGO DATE, 
	FECHA_BAJA_PAGO DATE,
	 CONSTRAINT "FORMAS_PAGO_COD_FP_PK" PRIMARY KEY ("CODIGO_FORMA_PAGO") ENABLE,
	 CONSTRAINT FORMAS_PAGO_ESTADO_CK CHECK (ESTADO_FORMA_PAGO IN ('AC','BA'))
   );

create table formas_pago_cliente
	(
		CODIGO_FORMA_PAGO NUMBER(5,0),
		CODIGO_CLIENTE NUMBER(5,0),
		ESTADO_FORMA_PAGO_CLIENTE CHAR (2),
		FECHA_ALTA_PAGO_CLIENTE DATE,
		FECHA_BAJA_PAGO_CLIENTE DATE,
		clave_forma_pago_cliente number (5,0),
		 CONSTRAINT PAGO_ESTADO_CK CHECK (ESTADO_FORMA_PAGO_CLIENTE IN ('AC','BA')),
		CONSTRAINT FORMA_PC_CODIGO_CLIENTE_FK FOREIGN KEY (CODIGO_CLIENTE)
		REFERENCES CLIENTES (CODIGO_CLIENTE),
		CONSTRAINT FORMA_PC_CODIFO_FORMA_PAGO_FK FOREIGN KEY (CODIGO_FORMA_PAGO)
		REFERENCES FORMAS_PAGO (CODIGO_FORMA_PAGO),
		constraint "clave_p" primary key (clave_forma_pago_cliente) enable
	);

CREATE TABLE  "PERSONAS_CONTACTO" 
   (	codigo_personacontacto number (10,0),
	"CODIGO_CLIENTE" NUMBER(5,0) NOT NULL ENABLE, 
	"NOMBRE_PERSONA_CONTACTO" VARCHAR2(35), 
	"TELEFONO_PERSONA_CONTACTO" NUMBER(9,0), 
	"EXTENSION_PERSONA_CONTACTO" NUMBER(6,0), 
	"CARGO_PERSONA_CONTACTO" VARCHAR2(35), 
	"HORARIO_PERSONA_CONTACTO" VARCHAR2(20), 
	"EMAIL_PERSONA_CONTACTO" VARCHAR2(35),
	constraint "codigo_personas_contacto_pk" primary key (codigo_personacontacto),
	 CONSTRAINT "PERSONAS_CONTAC_COD_CLI_FK" FOREIGN KEY ("CODIGO_CLIENTE")
	  REFERENCES  "CLIENTES" ("CODIGO_CLIENTE") ENABLE
   )

REM************ FIN TABLAS DE CLIENTES *****************************

REM******************** TABLAS DE PEDIDOS  *************************

CREATE TABLE  "PEDIDOS" 
   (	"NUMERO_PEDIDO" NUMBER(5,0), 
	"FECHA_PEDIDO" DATE, 
	"PORTE_PEDIDO" NUMBER(11,2), 
	"SEGURO_PEDIDO" NUMBER(11,2), 
	"OTROS_CARGOS_PEDIDO" NUMBER(11,2), 
	"TOTAL_CARGOS_PEDIDO" NUMBER(11,2), 
	"TOTAL_BRUTO_PEDIDO" NUMBER(11,2), 
	"PORCENTAJE_IVA_PEDIDO" NUMBER(2,0), 
	"IVA_PEDIDO" NUMBER(11,2), 
	"TOTAL_FACTURA_PEDIDO" NUMBER(11,2), 
	"CODIGO_CLIENTE" NUMBER(5,0) NOT NULL ENABLE, 
	 CONSTRAINT "PEDIDOS_NUMERO_PEDIDO_PK" PRIMARY KEY ("NUMERO_PEDIDO") ENABLE, 
	 CONSTRAINT "PEDIDOS_COD_CLI_FK" FOREIGN KEY ("CODIGO_CLIENTE")
	  REFERENCES  "CLIENTES" ("CODIGO_CLIENTE") ENABLE
   );

CREATE TABLE  "LINEA_PEDIDO"
   (	
	codigo_linea_pedido number(10,0),
	"CODIGO_ARTICULO" NUMBER(5,0), 
	"NUMERO_PEDIDO" NUMBER(5,0), 
	"PRECIO_UNIDAD_ARTICULO" NUMBER(11,2), 
	"NUMERO_UNIDADES_ARTICULO" NUMBER(5,0), 
	"PORCENTAJE_DESCUENTO" NUMBER(4,2), 
	 CONSTRAINT "LINEA_PEDIDO_NUM_PED_FK" FOREIGN KEY ("NUMERO_PEDIDO")
	  REFERENCES  "PEDIDOS" ("NUMERO_PEDIDO") ENABLE, 
	 CONSTRAINT "LINEA_PEDIDO_COD_ART_FK" FOREIGN KEY ("CODIGO_ARTICULO")
	  REFERENCES  "ARTICULOS" ("CODIGO_ARTICULO") ENABLE,
	CONSTRAINT "codigo_linea_pedido_PK" PRIMARY KEY (codigo_linea_pedido)
   );


REM******************** FIN TABLAS PEDIDOS *****************************

REM******************** TABLAS PROVEEDORES/ARTICULOS *******************

CREATE TABLE  "PROVEEDORES" 
   (	"CODIGO_PROVEEDOR" NUMBER(11,0), 
	"NOMBRE_PROVEEDOR" VARCHAR2(35), 
	"CIF_PROVEEDOR" VARCHAR2(10), 
	"NOMBRE_COMERCIAL_PROVEEDOR" VARCHAR2(40), 
	"CALLE_PROVEEDOR" VARCHAR2(40), 
	"CIUDAD_PROVEEDOR" VARCHAR2(40), 
	"CP_PROVEEDOR" NUMBER(5,0), 
	"PROVINCIA_PROVEEDOR" VARCHAR2(35), 
	"TELEFONO_PROVEEDOR" NUMBER(9,0), 
	"FAX_PROVEEDOR" NUMBER(9,0), 
	"EMAIL_PROVEEDOR" VARCHAR2(40), 
	"OBSERVACIONES_PROVEEDOR" CLOB, 
	 CONSTRAINT "PROVEEDORES_COD_PROV_PK" PRIMARY KEY ("CODIGO_PROVEEDOR") ENABLE
   );

CREATE TABLE  "ARTICULOS" 
   (	"CODIGO_ARTICULO" NUMBER(5,0) NOT NULL ENABLE, 
	"DESCRIPCION_ARTICULO" VARCHAR2(40), 
	"PRECIO_UNIDAD_ARTICULO" NUMBER(11,2), 
	CANTIDAD NUMBER(5),
	 CONSTRAINT "ARTICULOS_COD_ART_PK" PRIMARY KEY ("CODIGO_ARTICULO") ENABLE
   );

CREATE TABLE  "PROVEEDORES_ARTICULOS" 
   (	"CODIGO_PROVEEDOR" NUMBER(11,0), 
	"CODIGO_ARTICULO" NUMBER(20,0), 
	 CONSTRAINT "PROV_ART_COD_PROV_FK" FOREIGN KEY ("CODIGO_PROVEEDOR")
	  REFERENCES  "PROVEEDORES" ("CODIGO_PROVEEDOR") ENABLE, 
	 CONSTRAINT "PROV_ART_COD_ART_FK" FOREIGN KEY ("CODIGO_ARTICULO")
	  REFERENCES  "ARTICULOS" ("CODIGO_ARTICULO") ENABLE
   );

REM********** FIN PROVEEDORES/ARTICULOS  ****************************

REM******************* TABLAS PAGOS/VENCIMIENTOS ********************

CREATE TABLE  "VENCIMIENTOS" 
   (	
	codigo_vencimiento number(10,0),
	"FECHA_VENCIMIENTO" DATE, 
	"CANTIDAD_VENCIMIENTO" NUMBER(11,2), 
	"NUMERO_PEDIDO" NUMBER(5,0), 
	"FECHA_COBRO_VENCIMIENTO" DATE, 
	"NOMBRE_BANCO" VARCHAR2(40), 
	"ESTADO_VENCIMIENTO" CHAR(1),
 	CONSTRAINT codigo_vencimiento_PK PRIMARY KEY (codigo_vencimiento) ENABLE,
	"CODIGO_CLIENTE" NUMBER(5,0) NOT NULL ENABLE, 
	 CONSTRAINT "VENCIMIENTOS_COD_CLI_PK" FOREIGN KEY ("CODIGO_CLIENTE")
	  REFERENCES  "CLIENTES" ("CODIGO_CLIENTE") ENABLE
   );

CREATE TABLE  "PAGO_CLIENTES" 
   (	
	codigo_pago_cliente number (10,0),
	"CODIGO_FORMA_PAGO" NUMBER(5,0), 
	"CODIGO_CLIENTE" NUMBER(5,0),
 	 CONSTRAINT codigo_pago_cliente_PK PRIMARY KEY (codigo_pago_cliente) ENABLE,
	 CONSTRAINT "PAGO_CLIENTES_COD_CLI_FK" FOREIGN KEY ("CODIGO_CLIENTE")
	  REFERENCES  "CLIENTES" ("CODIGO_CLIENTE") ENABLE, 
	 CONSTRAINT "PAGO_CLIENTES_COD_FP_FK" FOREIGN KEY ("CODIGO_FORMA_PAGO")
	  REFERENCES  "FORMAS_PAGO" ("CODIGO_FORMA_PAGO") ENABLE
   );


REM*******************FIN TABLAS PAGOS/VENCIMIENTOS ********************

REM******************* TABLAS ROLES/TAREAS/USUARIOS *****************
CREATE TABLE  "ROLES" 
   (	"CODIGO_ROL" NUMBER(2,0), 
	"DESCRIPCION_ROL" VARCHAR2(100), 
	 CONSTRAINT "CODIGO_ROL_PK" PRIMARY KEY ("CODIGO_ROL") ENABLE
   )


CREATE TABLE  "TAREAS" 
   (	"CODIGO_TAREA" NUMBER(2,0), 
	"DESCRIPCION_TAREA" VARCHAR2(2000), 
	"VINCULO" VARCHAR2(50), 
	 CONSTRAINT "CODIGO_TAREA_PK" PRIMARY KEY ("CODIGO_TAREA") ENABLE
   )


CREATE TABLE  "USUARIOS" 
   (	"NOMBRE_USUARIO" VARCHAR2(20), 
	"PASSWORD" VARCHAR2(10), 
	"CODIGO_ROL" NUMBER(2,0),
	fecha_alta date,
	fecha_baja date,
	carpeta_documentacion varchar2(250),
	idioma char(2),
	 CONSTRAINT "NOMBRE_USUARIO_PK" PRIMARY KEY ("NOMBRE_USUARIO") ENABLE, 
	 CONSTRAINT "CODIGO_ROL_USUARIOS_FK" FOREIGN KEY ("CODIGO_ROL")
	  REFERENCES  "ROLES" ("CODIGO_ROL") ENABLE
	 

   )


CREATE TABLE  "ROLES_TAREAS" 
   (	"CODIGO_ROL" NUMBER(2,0), 
	"CODIGO_TAREA" NUMBER(2,0), 
	 CONSTRAINT "ROLES_TAREAS_PK" PRIMARY KEY ("CODIGO_ROL", "CODIGO_TAREA") ENABLE, 
	 CONSTRAINT "CODIGO_ROL_FK" FOREIGN KEY ("CODIGO_ROL")
	  REFERENCES  "ROLES" ("CODIGO_ROL") ENABLE, 
	 CONSTRAINT "CODIGO_TAREA_FK" FOREIGN KEY ("CODIGO_TAREA")
	  REFERENCES  "TAREAS" ("CODIGO_TAREA") ENABLE
   )

REM*******************FIN TABLAS ROLES/TAREAS/USUARIOS *****************


REM******************* TABLAS PAISES/PROVINCIAS/MUNICIPIOS *****************
R
CREATE TABLE  pais  (
   codigo_pais  number(11,0) NOT NULL,
   PAIs_ISONUM  number(6,0),
   PAIs_ISO2  char(2),
   PAIs_ISO3  char(3),
   PAIs_NOMBRE  varchar2(80),
  constraint pais_codigo_pais_PK PRIMARY KEY  ( codigo_pais )
);

CREATE TABLE  provincias  (
   codigo_provincia  number(2,0) NOT NULL ,
   provincia  varchar2(255) NOT NULL,
  constraint provincias_codigo_provincia_PK primary key (codigo_provincia)
);


CREATE TABLE  municipios (
   codigo_municipio  number(11,0) NOT NULL,
   provincia number(2,0) NOT NULL,
   municipio  varchar2(255) NOT NULL,
  constraint municipios_PK PRIMARY KEY (codigo_municipio,provincia)
);

REM *********FIN TABLAS DE PAISES/PROVINCIAS/MUNICIPIOS****************

rem ********* tabla REGISTRO DE ACCESOS A LA APLICACION

CREATE TABLE REGISTRO_USUARIOS(
	codigo_registro number(10,0),
	codigo_usuario varchar2(20) not null,
	fecha_entrada date not null,
	fecha_salida date ,
	duracion varchar2(50),
	ficheros_subidos number(3,0),
	informacion_subida number (15,2),

	constraint registro_codigo_registro_PK primary key (codigo_registro)
)
********  SUBSISTEMA DE REGISTRO DE TRABAJOS Y USUARIOS EN LA APLICACION ******

CREATE TABLE TAREAS_USUARIOS(
	codigo_tareausuario number (10,0),
	descripcion_tareausuario varchar2(150),
	estado_tarea varchar2 (2),

	constraint codigo_tareausuario_pk primary key (codigo_tareausuario),
	constraint estado_tarea_ch check (estado_tarea in ('ac','ba'))
 )

CREATE TABLE TAREAS_REALIZADAS(
	codigo_tarearealizada number(10,0),
	usuario varchar2 (20) not null,
	codigo_tareausuario number (10,0),
	fecha_realizacion date,
	datos_añadidos blob,
	datos_modificados blob,
	datos_eliminados blob,

	constraint codigo_tarearealizada_pk primary key (codigo_tarearealizada),
	CONSTRAINT tarea_usuario_FK FOREIGN KEY (codigo_tareausuario)
	  REFERENCES  TAREAS_USUARIOS (codigo_tareausuario) ENABLE	
)

******  FIN SUBSISTEMA DE RGISTRO DE TRABAJOS Y USUARIOS EN LA APLICACION ****


create table calles (
	codigo_calle number (10,0),
	nombre_calle varchar2 (100),
	codigo_postal char(5),
	zona_codigo_postal varchar2 (100),
	codigo_municipio number(11,0),
	provincia number(2,0),
	codigo_provincia number(2,0),

	constraint calles_codigo_calle_PK primary key (codigo_calle),
	CONSTRAINT "municipio_FK" FOREIGN KEY (codigo_municipio,provincia)
	  REFERENCES  municipios (codigo_municipio,provincia),
	CONSTRAINT "provincia_FK" FOREIGN KEY (codigo_provincia)
	  REFERENCES  provincias (codigo_provincia)  
)



rem ****************** TABLA DE SERVICIO AUTENTICACION  ***************
create table autenticacion_servicios (
	nombre_cliente varchar2(100),
	palabra_clave varchar2(100),
	nivelPermiso number(2,0),
	
	constraint auten_nombre_clave_PK primary key (nombre_cliente,palabra_clave)
)

rem ********** SECUENCIADORES PARA LA BASE DE DATOS  *******************
create sequence codigo_registro;
create sequence num_linea_pedido;
create sequence codigo_cliente;
create sequence numero_pedido;
create sequence pagos_clientes;
create sequence numero_vencimiento; 
create sequence codigo_articulo;
create sequence codigo_proveedores;
create sequence codigo_calle;
create sequence codigo_forma_pago_cliente;

create sequence codigo_tareausuario;
create sequence codigo_tarearealizada;
create sequence codigo_banco;

create sequence codigo_usuario;
create sequence codigo_rol;
create sequence codigo_tarea;

