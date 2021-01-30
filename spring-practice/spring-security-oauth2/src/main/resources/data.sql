INSERT INTO authority VALUES (101, 'ADMIN');
INSERT INTO authority VALUES (102, 'USER');
INSERT INTO authority VALUES (103, 'READ_ONLY_USER');

INSERT INTO user VALUES (501, 'omkar','$2a$10$sIzg/riiBF8HoU47DST9b.JlUaM2OBZSFEjrDeEsRiD79TrkjhxLC', 'Admin Dashboard');
INSERT INTO user VALUES (502, 'laddu','$2a$10$sIzg/riiBF8HoU47DST9b.JlUaM2OBZSFEjrDeEsRiD79TrkjhxLC', 'Publisher Dashboard');
INSERT INTO user VALUES (503, 'soni','$2a$10$sIzg/riiBF8HoU47DST9b.JlUaM2OBZSFEjrDeEsRiD79TrkjhxLC', 'Client DashBoard');

INSERT INTO user_authority values (801, 501, 101);
INSERT INTO user_authority values (802, 502, 102);
INSERT INTO user_authority values (803, 503, 103);