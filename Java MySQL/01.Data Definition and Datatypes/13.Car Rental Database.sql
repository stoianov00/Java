CREATE DATABASE car_rental;

USE car_rental;

CREATE TABLE categories (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    category VARCHAR(50) NOT NULL,
    daily_rate DOUBLE DEFAULT 0,
    weekly_rate DOUBLE DEFAULT 0,
    monthly_rate DOUBLE DEFAULT 0,
    weekend_rate DOUBLE DEFAULT 0
);

CREATE TABLE cars (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL,
    car_year YEAR NOT NULL,
    category_id INT(11) UNSIGNED NOT NULL,
    doors TINYINT UNSIGNED NOT NULL,
    picture BLOB,
    car_condition VARCHAR(20),
    available BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE employees (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE customers (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    full_name VARCHAR(60) NOT NULL,
    address VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    zip_code INT(4) NOT NULL,
    notes TEXT
);

CREATE TABLE rental_orders (
    id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT(11) UNSIGNED NOT NULL,
    customer_id INT(11) UNSIGNED NOT NULL,
    car_id INT(11) UNSIGNED NOT NULL,
    car_condition VARCHAR(20),
    tank_level DOUBLE,
    kilometrage_start DOUBLE,
    kilometrage_end DOUBLE,
    total_kilometrage DOUBLE,
    start_date DATE,
    end_date DATE,
    total_days INT(11) UNSIGNED,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(30),
    notes TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES ('Category 1', 1.1, 2.1, 3.1, 4.1),
	   ('Category 2', 1.2, 2.2, 3.2, 4.2),
	   ('Category 3', 1.3, 2.3, 3.3, 4.3);
       
INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, car_condition)
VALUES ('Plate Num 1', 'Maker 1', 'Model 1', '1970', 1, 2, 'Good'),
	   ('Plate Num 2', 'Maker 2', 'Model 2', '1980', 2, 4, 'Scrap'),
	   ('Plate Num 3', 'Maker 3', 'Model 3', '1990', 3, 5, 'Good');
       
INSERT INTO employees(first_name, last_name, title, notes)
VALUES ('Elon', 'Musk', 'CEO', ''),
	   ('Jack', 'Ma', 'Alibaba CEO', ''),
       ('Richard', 'Branson', 'Virgin group', '');
       
INSERT INTO customers(full_name, address, city, zip_code, notes)
VALUES ('Gosho Goshev', 'A casstle', 'Sofia', 1000, ''),
	   ('Pesho Peshev', 'A boat', 'Varna', 2000, ''),
	   ('Bai Ivan', 'Under the bridge', 'Sofia', 1000, '');
       
INSERT INTO rental_orders(employee_id, customer_id, car_id, car_condition, start_date)
VALUES (1, 3, 2, 'Good', NOW()),
	   (2, 1, 3, 'Bad', NOW()),
	   (3, 2, 1, 'OK', NOW());
       
       

       





