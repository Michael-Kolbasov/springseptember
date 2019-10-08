create table cats (id bigint not null auto_increment, name varchar(255) not null, age integer not null, primary key (id));

create table users (id bigint not null auto_increment, name varchar(255) not null unique, password varchar(255) not null, role varchar(50) not null default 'ROLE_USER', primary key (id));