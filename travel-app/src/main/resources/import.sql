CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
insert into Cliente(id, nome) values (nextval('hibernate_sequence'), 'ana');
insert into Cliente(id, nome) values (nextval('hibernate_sequence'), 'pedro');
insert into Cliente(id, nome) values (nextval('hibernate_sequence'), 'maria');
insert into Cliente(id, nome) values (nextval('hibernate_sequence'), 'estevao');
