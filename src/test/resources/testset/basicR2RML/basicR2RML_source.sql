drop schema if exists "basicR2RML" cascade;
create schema "basicR2RML";

create table "basicR2RML"."TABLE1"
(
    "m" int primary key,
    "n" int,
    "o" int
);
create table "basicR2RML"."TABLE2"
(
    "m" int primary key,
    "n" int,
    "o" int
);
create table "basicR2RML"."TABLE3"
(
    "m" int primary key
);
create table "basicR2RML"."JOIN_TABLE"
(
    "domain" int,
    "range"  int,
    primary key ("domain", "range")
-- Lorsqu'on inclue des clés référentielles dans la table de jointure, Ontop est en mesure d'optimiser la définition
-- de la classe tst2
,
    foreign key ("domain") references "basicR2RML"."TABLE2" ("m"),
    foreign key ("range") references "basicR2RML"."TABLE2" ("m")
);

insert into "basicR2RML"."TABLE1"
values (1, 2, 3),
       (2, 5, 6),
       (3, 8, 9),
       (4, 11, 12),
       (5, 14, 15);

insert into "basicR2RML"."TABLE2"
values (1, 2, 3),
       (2, 5, 6),
       (3, 8, 9);

insert into "basicR2RML"."TABLE3"
values (1),
       (2),
       (3),
       (4);

insert into "basicR2RML"."JOIN_TABLE"
values (1, 2),
       (1, 3),
       (2, 3);
