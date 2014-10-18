drop table Client;

create table Client (
  cli_clientId char(32) not null,
  cli_name varchar(20) not null,
  cli_birthdate date not null,
  cli_sex char(1) not null,
  cli_phone varchar(20) null,
  cli_address varchar(50) null,
  constraint pk$client_id primary key (cli_clientId)
)
;

drop table Auto;

create table Auto (
  aut_autoId char(6) not null,
  aut_markName varchar(20) not null,
  aut_modelName varchar(20) not null,
  constraint pk$auto_id primary key (aut_autoId)
)
;

drop table ClientAuto;

create table ClientAuto (
  cli_clientId char(32) not null,
  aut_autoId char(6) not null,
  constraint fk$client_id foreign key (cli_clientId) references Client(cli_clientId),
  constraint fk$auto_id foreign key (aut_autoId) references Auto(aut_autoId)
)
;

CREATE SEQUENCE Auto_id_seq;