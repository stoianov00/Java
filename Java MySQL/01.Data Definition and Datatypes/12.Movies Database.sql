CREATE DATABASE Movies;

USE Movies;

CREATE TABLE directories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE genres(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	genre_name VARCHAR(50) NOT NULL,
	notes TEXT
);

CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	category_name VARCHAR(50) NOT NULL,
	notes TEXT
);

CREATE TABLE movies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    director_id INT UNSIGNED NOT NULL,
	copyright_year YEAR NOT NULL,
	length TIME NOT NULL,
	genre_id INT UNSIGNED NOT NULL,
	category_id INT UNSIGNED NOT NULL,
	rating DOUBLE NOT NULL DEFAULT 0,
	notes TEXT
);

INSERT INTO movies(title, director_id, copyright_year, length, genre_id, category_id)
VALUES ('dave', 2, '2016', 23, 1, 2),
	   ('dave', 2, '2016', 23, 1, 2),
	   ('dave', 2, '2016', 23, 1, 2),
	   ('dave', 2, '2016', 23, 1, 2),
	   ('dave', 1, '2016', 23, 1, 2);

INSERT INTO directors(director_name, notes)
VALUES ('dasdasd', 'fasdfasdfasdfa'),
	   ('dasdasd', 'fasdfasdfasdfa'),
	   ('dasdasd', 'fasdfasdfasdfa'),
	   ('dasdasd', 'fasdfasdfasdfa'),
	   ('dasdasd', 'fasdfasdfasdfa');

INSERT INTO categories(category_name)
VALUES ('wi-fi'),
	   ('wi-fi'),
	   ('wi-fi'),
	   ('wi-fi'),
	   ('wi-fi');

INSERT INTO genres(genre_name, notes)
VALUES ('dasdad', 'kaman'),
	   ('dasdad', 'kaman'),
	   ('dasdad', 'kaman'),
	   ('dasdad', 'kaman'),
	   ('dasdad', 'kaman');














