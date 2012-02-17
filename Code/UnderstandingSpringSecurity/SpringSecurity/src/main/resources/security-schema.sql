-- ref. Appendix A of Spring Sec 3.0 manual
  create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
-- Ch 4 Custom Salt exercise
      enabled boolean not null
--      enabled boolean not null,
--      salt varchar_ignorecase(25) not null
      );

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);

create table groups (
  id bigint primary key, 
  group_name varchar(50) not null);

create table group_authorities (
  group_id bigint not null, 
  authority varchar(50) not null, 
  constraint fk_group_authorities_group foreign key(group_id) references groups(id));

create table group_members (
  id bigint primary key, 
  username varchar(50) not null, 
  group_id bigint not null, 
  constraint fk_group_members_group foreign key(group_id) references groups(id));