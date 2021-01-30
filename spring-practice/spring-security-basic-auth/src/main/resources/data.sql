INSERT INTO users(username,password,enabled) VALUES ('priya','$2a$10$sIzg/riiBF8HoU47DST9b.JlUaM2OBZSFEjrDeEsRiD79TrkjhxLC', true);
INSERT INTO users(username,password,enabled) VALUES ('naveen','$2a$10$sIzg/riiBF8HoU47DST9b.JlUaM2OBZSFEjrDeEsRiD79TrkjhxLC', true);

INSERT INTO authorities (username, authority) VALUES ('priya', 'USER');
INSERT INTO authorities (username, authority) VALUES ('priya', 'ADMIN');
INSERT INTO authorities (username, authority) VALUES ('naveen', 'USER');