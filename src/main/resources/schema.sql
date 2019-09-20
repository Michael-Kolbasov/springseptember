drop table if exists cats cascade;

create table cats (
    id bigint not null auto_increment,
    name varchar(255) not null,
    age integer not null,
    primary key (id)
);