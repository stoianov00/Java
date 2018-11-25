CREATE DATABASE soft_uni;

USE soft_uni;

CREATE TABLE towns (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_towns PRIMARY KEY (id)
);

CREATE TABLE addresses (
    id INT(11) AUTO_INCREMENT NOT NULL,
    address_text VARCHAR(30) NOT NULL,
    town_id INT,
    CONSTRAINT pk_addresses PRIMARY KEY (id),
    CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id)
        REFERENCES towns (id)
);

CREATE TABLE departments (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_departments PRIMARY KEY (id)
);

CREATE TABLE employees (
    id INT(11) AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(30),
    last_name VARCHAR(30) NOT NULL,
    job_title VARCHAR(30) NOT NULL,
    department_id INT,
    hire_date DATE,
    salary DECIMAL(10 , 2 ),
    address_id INT,
    CONSTRAINT pk_employees PRIMARY KEY (id),
    CONSTRAINT fk_employees_departments FOREIGN KEY (department_id)
        REFERENCES departments (id),
    CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id)
        REFERENCES addresses (id)
);
