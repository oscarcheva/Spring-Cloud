INSERT INTO USER_DETAILS(id, birth_date, name)
VALUES (1, CURRENT_DATE(), 'OSCAR');

INSERT INTO USER_DETAILS(id, birth_date, name)
VALUES (2, CURRENT_DATE(), 'ENRIQUE');

INSERT INTO USER_DETAILS(id, birth_date, name)
VALUES (3, CURRENT_DATE(), 'LUS');

INSERT INTO POST (id, description, user_id)
VALUES (3, 'HELLO', 1);

INSERT INTO POST (id, description, user_id)
VALUES (4, 'HOW ARE YOU', 2);

INSERT INTO POST (id, description, user_id)
VALUES (5, 'BYE BYE', 1);