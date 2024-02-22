DROP TABLE IF EXISTS Person CASCADE;
DROP SEQUENCE IF EXISTS Person_SEQ;

CREATE SEQUENCE Person_SEQ START WITH 1 INCREMENT BY 50;

CREATE TABLE Person (
     birth DATE,
     status SMALLINT CHECK (status BETWEEN 0 AND 1),
     id BIGINT NOT NULL,
     name VARCHAR(255),
     PRIMARY KEY (id)

);

INSERT INTO person (id, birth, name, status) VALUES (1, '1995-09-12', 'Emily Brown', 0);
INSERT INTO person (id, birth, name, status) VALUES (2, '2000-09-12', 'Kevin Brown', 1);
INSERT INTO person (id, birth, name, status) VALUES (3, '1963-09-12', 'Christ Brown', 0);