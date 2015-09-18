# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table noticia (
  id                        bigint not null,
  titulo                    varchar(255),
  descripcion               varchar(255),
  imagen                    varchar(255),
  enlace                    varchar(255),
  fecha                     timestamp,
  puntos                    bigint,
  constraint pk_noticia primary key (id))
;

create table usuario (
  id                        bigint not null,
  usuario                   varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id))
;

create sequence noticia_seq;

create sequence usuario_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists noticia;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists noticia_seq;

drop sequence if exists usuario_seq;

