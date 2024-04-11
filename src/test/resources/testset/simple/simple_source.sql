drop table if exists "TABLE1" cascade;
drop table if exists "TABLE2" cascade;
drop table if exists "TABLE3" cascade;

create table "TABLE1"
(
    "m" int primary key,
    "n" int,
    "o" int
);
create table "TABLE2"
(
    "m" int primary key,
    "n" int,
    "o" int
);
create table "TABLE3"
(
    "m" int primary key
);

insert into "TABLE1"
values (1, 2, 3);
insert into "TABLE1"
values (2, 5, 6);
insert into "TABLE1"
values (3, 8, 9);
insert into "TABLE1"
values (4, 11, 12);
insert into "TABLE1"
values (5, 14, 15);

insert into "TABLE2"
values (1, 2, 3);
insert into "TABLE2"
values (2, 5, 6);
insert into "TABLE2"
values (3, 8, 9);

insert into "TABLE3"
values (1);
insert into "TABLE3"
values (2);
insert into "TABLE3"
values (3);
insert into "TABLE3"
values (4);
