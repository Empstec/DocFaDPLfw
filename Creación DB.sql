CREATE TABLE Caracteristicas
  (
    id_Caracteristica INTEGER NOT NULL ,
    isRoot            CHAR (1) NOT NULL ,
    Nombre            VARCHAR (255) NOT NULL ,
    id_Documento      INTEGER NOT NULL 
  ) ;
ALTER TABLE Caracteristicas ADD CONSTRAINT Caracteristicas_PK PRIMARY KEY ( id_Caracteristica ) ;
ALTER TABLE Caracteristicas MODIFY COLUMN id_Caracteristica INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE Contenidos
  (
    id_Contenido   INTEGER NOT NULL,
    Tipo_Propiedad VARCHAR (50) NOT NULL ,
    Contenido      VARCHAR (16383) NOT NULL ,
    Tipo           VARCHAR (50) NOT NULL ,
    id_Usuario     INTEGER NOT NULL
  ) ;
ALTER TABLE Contenidos ADD CONSTRAINT Contenidos_PK PRIMARY KEY ( id_Contenido ) ;
ALTER TABLE Contenidos MODIFY COLUMN id_Contenido INTEGER NOT NULL AUTO_INCREMENT;

CREATE TABLE Contenidos_Propiedades
  (
    Propiedades_id INTEGER NOT NULL ,
    Contenidos_id  INTEGER NOT NULL
  ) ;
ALTER TABLE Contenidos_Propiedades ADD CONSTRAINT Contenidos_Propiedades_PK PRIMARY KEY ( Propiedades_id, Contenidos_id ) ;


CREATE TABLE Documentos
  (
    id_Documento INTEGER NOT NULL,
    Titulo       VARCHAR (255) NOT NULL ,
    Autor        INTEGER NOT NULL ,
    Descripcion  VARCHAR (5000)
  ) ;
ALTER TABLE Documentos ADD CONSTRAINT Documentos_PK PRIMARY KEY ( id_Documento ) ;
ALTER TABLE Documentos MODIFY COLUMN id_Documento INTEGER NOT NULL AUTO_INCREMENT;


CREATE TABLE Grupo_Relaciones
  (
    id_Relacion         INTEGER NOT NULL ,
    mult_Min            INTEGER ,
    mult_Max            INTEGER ,
    id_Caracteristica   INTEGER NOT NULL ,
    id_Relacion_Directa INTEGER NOT NULL
  ) ;
ALTER TABLE Grupo_Relaciones ADD CONSTRAINT Grupo_Relaciones_PK PRIMARY KEY ( id_Relacion ) ;
ALTER TABLE Grupo_Relaciones MODIFY COLUMN id_Relacion INTEGER NOT NULL AUTO_INCREMENT;


CREATE TABLE Incompatibilidades
  (
    id_Caracteristica INTEGER NOT NULL ,
    Incompatible      INTEGER NOT NULL ,
    Tipo              VARCHAR (50)
  ) ;
ALTER TABLE Incompatibilidades ADD CONSTRAINT Incompatibilidades_PK PRIMARY KEY ( Incompatible, id_Caracteristica ) ;


CREATE TABLE Permisos
  (
    id_Documento INTEGER NOT NULL ,
    id_Usuario   INTEGER NOT NULL ,
    Permisos     VARCHAR (500)
  ) ;
ALTER TABLE Permisos ADD CONSTRAINT Permisos_PK PRIMARY KEY ( id_Documento, id_Usuario ) ;


CREATE TABLE Propiedades
  (
    id_Propiedad      INTEGER NOT NULL ,
    Nombre            VARCHAR (255) NOT NULL ,
    Tipo              VARCHAR (500) NOT NULL ,
    id_Caracteristica INTEGER NOT NULL
  ) ;
ALTER TABLE Propiedades ADD CONSTRAINT Propiedades_PK PRIMARY KEY ( id_Propiedad ) ;
ALTER TABLE Propiedades MODIFY COLUMN id_Propiedad INTEGER NOT NULL AUTO_INCREMENT;


CREATE TABLE Relaciones_Directas
  (
    id_Relacion       INTEGER NOT NULL ,
    mult_Min          INTEGER ,
    mult_Max          INTEGER ,
    id_Caracteristica INTEGER NOT NULL ,
    Destino           INTEGER NOT NULL
  ) ;
ALTER TABLE Relaciones_Directas ADD CONSTRAINT Relaciones_PK PRIMARY KEY ( id_Relacion ) ;
ALTER TABLE Relaciones_Directas MODIFY COLUMN id_Relacion INTEGER NOT NULL AUTO_INCREMENT;


CREATE TABLE Requerimientos
  (
    id_Caracteristica INTEGER NOT NULL ,
    Requiere          INTEGER NOT NULL ,
    Tipo              VARCHAR (50)
  ) ;
ALTER TABLE Requerimientos ADD CONSTRAINT Requerimientos_PK PRIMARY KEY ( id_Caracteristica, Requiere ) ;


CREATE TABLE Usuarios
  (
    id_Usuario   INTEGER NOT NULL,
    Nombre       VARCHAR (100) NOT NULL ,
    Apellidos    VARCHAR (200) ,
    Sexo		 CHAR ,
    eMail        VARCHAR (255) NOT NULL ,
    Pass         VARCHAR (100) NOT NULL ,
    Empresa      VARCHAR (100) ,
    Departamento VARCHAR (100) ,
    Rol          VARCHAR (500) ,
    Pais         VARCHAR (150) ,
    Provincia    VARCHAR (250) ,
    Poblacion    VARCHAR (500) ,
    Direccion    VARCHAR (500)
  ) ;
ALTER TABLE Usuarios ADD CONSTRAINT Usuario_PK PRIMARY KEY ( id_Usuario ) ;
ALTER TABLE Usuarios MODIFY COLUMN id_Usuario INTEGER NOT NULL AUTO_INCREMENT;


ALTER TABLE Caracteristicas ADD CONSTRAINT Car_Doc_FK FOREIGN KEY ( id_Documento ) REFERENCES Documentos ( id_Documento ) ON
DELETE CASCADE ;

ALTER TABLE Contenidos_Propiedades ADD CONSTRAINT Cont_Prop_Cont_FK FOREIGN KEY ( Contenidos_id ) REFERENCES Contenidos ( id_Contenido ) ON
DELETE CASCADE ;

ALTER TABLE Contenidos_Propiedades ADD CONSTRAINT Cont_Prop_Prop_FK FOREIGN KEY ( Propiedades_id ) REFERENCES Propiedades ( id_Propiedad ) ON
DELETE CASCADE ;

ALTER TABLE Contenidos ADD CONSTRAINT Cont_Us_FK FOREIGN KEY ( id_Usuario ) REFERENCES Usuarios ( id_Usuario ) ;

ALTER TABLE Documentos ADD CONSTRAINT Documentos_Usuarios FOREIGN KEY ( Autor ) REFERENCES Usuarios ( id_Usuario ) ;

ALTER TABLE Grupo_Relaciones ADD CONSTRAINT Grupo_Rel_Car_FK FOREIGN KEY ( id_Caracteristica ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Grupo_Relaciones ADD CONSTRAINT Grupo_Rel_Rel_Dir_FK FOREIGN KEY ( id_Relacion_Directa ) REFERENCES Relaciones_Directas ( id_Relacion ) ;

ALTER TABLE Incompatibilidades ADD CONSTRAINT Inc_Car_Dest_FK FOREIGN KEY ( Incompatible ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Incompatibilidades ADD CONSTRAINT Inc_Car_Or_FK FOREIGN KEY ( id_Caracteristica ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Permisos ADD CONSTRAINT Permiso_Documento FOREIGN KEY ( id_Documento ) REFERENCES Documentos ( id_Documento ) ON
DELETE CASCADE ;

ALTER TABLE Permisos ADD CONSTRAINT Permisos_Usuario FOREIGN KEY ( id_Usuario ) REFERENCES Usuarios ( id_Usuario ) ON
DELETE CASCADE ;

ALTER TABLE Propiedades ADD CONSTRAINT Prop_Car_FK FOREIGN KEY ( id_Caracteristicas ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Relaciones_Directas ADD CONSTRAINT Rel_Dir_Car_FK FOREIGN KEY ( Destino ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Relaciones_Directas ADD CONSTRAINT Relaciones_Caracteristicas FOREIGN KEY ( id_Caracteristica ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Requerimientos ADD CONSTRAINT Req_Car_Dest_FK FOREIGN KEY ( Requiere ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;

ALTER TABLE Requerimientos ADD CONSTRAINT Req_Car_Or_FK FOREIGN KEY ( id_Caracteristica ) REFERENCES Caracteristicas ( id_Caracteristica ) ON
DELETE CASCADE ;
