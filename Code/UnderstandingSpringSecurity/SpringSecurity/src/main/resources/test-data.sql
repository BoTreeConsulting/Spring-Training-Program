insert into training_models_annotations_test.users(username, password, enabled) values ('admin','admin',true);
insert into training_models_annotations_test.authorities(username,authority) values ('admin','ROLE_USER');
insert into training_models_annotations_test.authorities(username,authority) values ('admin','ROLE_ADMIN');
insert into training_models_annotations_test.users(username, password, enabled) values ('guest','guest',true);
insert into training_models_annotations_test.authorities(username,authority) values ('guest','ROLE_USER');
commit;
