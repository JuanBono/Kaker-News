# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table noticia (
  id                        bigint not null,
  titulo                    varchar(255),
  usuario_id                bigint,
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

alter table noticia add constraint fk_noticia_usuario_1 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_noticia_usuario_1 on noticia (usuario_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists noticia;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists noticia_seq;

drop sequence if exists usuario_seq;

