create table player (
    id bigint not null primary key,
    name varchar(50) not null,
    score int null
);

insert into player values (1, 'Teszt Elek', 10);