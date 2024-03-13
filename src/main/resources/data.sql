INSERT INTO authorities(authorities_id,authority_name) VALUES('1','READ'),('2','UPDATE'),('3','CREATE'),('4','DELETE');
INSERT INTO roles(roles_id,roles_name) VALUES('1','ADMIN'),('2','USER');
INSERT INTO roles_authorities(authorities_id,roles_id) VALUES('1','1'),('2','1'),('3','1'),('4','1'),('1','2');
INSERT INTO "user"(role_roles_id,user_id,user_name,user_password) VALUES('1','1','adminer','12345678'),('2','2','usererer','12345678');

INSERT INTO "returns"("returns_id","returns_order_id","returns_amount","returns_reason") VALUES(1,31231,123.23,'Good REturn Rason');