CREATE DATABASE users_db;

USE users_db;

CREATE TABLE users(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) UNIQUE NOT NULL,
    profile_picture BLOB(900),
    last_login_time TIMESTAMP,
    is_deleted BIT
);

INSERT INTO users(username, password, profile_picture, last_login_time, is_deleted)
	VALUES ('dave1', '1234', NULL, date(now()), 1),
		   ('pesoh2', '1324', NULL, date(now()), 0),
           ('draft3', '14524', NULL, date(now()), 1),
		   ('xz1sh6', '1324354', NULL, date(now()), 1),
           ('creg8', '133124', NULL, date(now()), 0);
           
           