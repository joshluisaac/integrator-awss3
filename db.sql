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


--password
insert into avant_user (user_id, user_name, encryted_password, enabled)
values (1, 'zoe@avantsystems.com.au', '$2a$10$EbciIqCtRPHkxtYsgzfAousgZZjnpJfzokMG8o8/BHUISK4s5Mpza', 1);

insert into avant_user (user_id, user_name, encryted_password, enabled)
values (2, 'joshua@avantsystems.com.au', '$2a$10$EbciIqCtRPHkxtYsgzfAousgZZjnpJfzokMG8o8/BHUISK4s5Mpza', 1);

insert into avant_user (user_id, user_name, encryted_password, enabled)
values (3, 'info@avantsystems.com.au', '$2a$10$EbciIqCtRPHkxtYsgzfAousgZZjnpJfzokMG8o8/BHUISK4s5Mpza', 1);

insert into avant_user (user_id, user_name, encryted_password, enabled)
values (4, 'admin@avantsystems.com.au', '$2a$10$EbciIqCtRPHkxtYsgzfAousgZZjnpJfzokMG8o8/BHUISK4s5Mpza', 1);

insert into avant_user (user_id, user_name, encryted_password, enabled)
values (5, 'sales@avantsystems.com.au', '$2a$10$EbciIqCtRPHkxtYsgzfAousgZZjnpJfzokMG8o8/BHUISK4s5Mpza', 1);

insert into avant_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into avant_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');
insert into avant_role (ROLE_ID, ROLE_NAME) values (3, 'ROLE_SALES');
insert into avant_role (ROLE_ID, ROLE_NAME) values (4, 'ROLE_ENQUIRES');

--zoe
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);
--joshua
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);
--admin
insert into avant_user_role (ID, USER_ID, ROLE_ID) values (4, 4, 1);

