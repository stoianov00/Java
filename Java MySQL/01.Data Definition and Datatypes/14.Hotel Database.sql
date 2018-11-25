CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE employees (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE customers (
    account_number INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    emergency_name VARCHAR(50),
    emergency_number VARCHAR(20),
    notes TEXT
);

CREATE TABLE room_status(
    room_status INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    notes TEXT
);

CREATE TABLE room_types (
    room_type INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    notes TEXT
);

CREATE TABLE bed_types (
    bed_type INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    notes TEXT
);

CREATE TABLE rooms (
    room_number INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    room_type INT NOT NULL,
    bed_type INT NOT NULL,
    rate DOUBLE DEFAULT 0,
    room_status INT NOT NULL,
    notes TEXT
);

CREATE TABLE payments (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT NOT NULL,
    payment_date DATE NOT NULL,
    account_number INT NOT NULL,
    first_date_occupied DATE,
    last_date_occupied DATE,
    total_days INT,
    amount_charged DOUBLE,
    tax_rate DOUBLE,
    tax_amount DOUBLE,
    payment_total DOUBLE,
    notes TEXT
);

CREATE TABLE occupancies (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT NOT NULL,
    date_occupied DATE NOT NULL,
    account_number INT NOT NULL,
    room_number INT NOT NULL,
    rate_applied DOUBLE,
    phone_charge DOUBLE,
    notes TEXT
);

INSERT INTO employees(first_name, last_name, title, notes)
VALUES ('Gosho', 'Goshev', 'Boss', ''),
	   ('Pesho', 'Peshev', 'Supervisor', ''),
	   ('Bai', 'Ivan', 'Worker', 'Can do any work');
       
       
INSERT INTO customers(first_name, last_name, phone_number)
VALUES ('Gosho', 'Goshev', '123'),
	   ('Pesho', 'Peshev', '44-2432'),
	   ('Bai', 'Ivan', '007');
       
INSERT INTO room_status(notes)
VALUES ('Free'),
	   ('For clean'),
	   ('Occupied');
       
INSERT INTO room_types(notes)
VALUES ('Small'),
	   ('Medium'),
	   ('Appartment');
       
INSERT INTO bed_types(notes)
VALUES ('Single'),
	   ('Double'),
	   ('Water-filled');
       
INSERT INTO rooms(room_type, bed_type, room_status)
VALUES (1, 1, 1),
	   (2, 2, 2),
	   (3, 3, 3);
       
INSERT INTO payments(employee_id, payment_date, account_number)
VALUES (1, DATE(NOW()), 1),
	   (2, DATE(NOW()), 2),
	   (3, DATE(NOW()), 3);
       
INSERT INTO occupancies (employee_id, date_occupied, account_number, room_number)
VALUES (1, DATE(NOW()), 1, 1),
	   (2, DATE(NOW()), 2, 2),
	   (3, DATE(NOW()), 3, 3);


