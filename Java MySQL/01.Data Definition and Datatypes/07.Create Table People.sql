CREATE DATABASE people_db;

USE people_db;

CREATE TABLE people(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    gender ENUM('m', 'f') NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people(name, picture, height, weight, gender, birthdate, biography)
 VALUES ('Dave', NULL, 1.90, 90.0, 'm', '1993-09-15', 'I am Dave'),
		('Elon', NULL, 1.80, 81.0, 'm', '1971-01-04', 'I am Elon'),
        ('Casey', NULL, 1.75, 70.0, 'm', '1984-07-13', 'I am Casey'),
        ('Barbara', NULL, 1.70, 63.0, 'f', '1962-09-15', 'I am Barbara'),
        ('Konstantin', NULL, 1.82, 110.0, 'm', '2000-10-18', 'I am Konstantin');