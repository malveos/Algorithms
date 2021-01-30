drop table authorities if exists;
drop table users if exists;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
CREATE TABLE authorities (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (authority,username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
