# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        bigint not null,
  name                      varchar(255),
  start_date                varchar(255),
  due_date                  varchar(255),
  task_type_id              varchar(255),
  description               varchar(255),
  is_done                   boolean,
  constraint pk_task primary key (id))
;

create table task_type (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_task_type primary key (id))
;

create sequence task_seq;

create sequence task_type_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists task;

drop table if exists task_type;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists task_seq;

drop sequence if exists task_type_seq;

