create table avant_user
(
  user_id           bigint not null,
  user_name         varchar(36) not null,
  encryted_password varchar(128) not null,
  enabled           int not null 
) ;

create table avant_role
(
  role_id   bigint not null,
  role_name varchar(30) not null
) ;

create table avant_user_role
(
  id      bigint not null,
  user_id bigint not null,
  role_id bigint not null
);

create table avant_persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    primary key (series)
     
);

insert into avant_user (user_id, user_name, encryted_password, enabled)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into avant_user (user_id, user_name, encryted_password, enabled)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into avant_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into avant_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');

insert into avant_user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);

