DROP table user_authority if exists;
drop table user if exists;
drop table authority if exists;

CREATE TABLE user (
	user_id int(11) NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(100) NOT NULL,
	dashboard VARCHAR(45) NOT NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE authority (
	authority_id int(11) NOT NULL AUTO_INCREMENT,
	authority varchar(45) NOT NULL,
	PRIMARY KEY (authority_id)
);

CREATE TABLE user_authority (
	user_authority_map_id int(11) NOT NULL AUTO_INCREMENT,
	user_id varchar(45) NOT NULL,
	authority_id varchar(45) NOT NULL,
	PRIMARY KEY (user_authority_map_id),
	UNIQUE KEY uni_username_role (user_id, authority_id),
	CONSTRAINT fk_1 FOREIGN KEY (user_id) REFERENCES user (user_id),
	CONSTRAINT fk_2 FOREIGN KEY (authority_id) REFERENCES authority (authority_id)
);