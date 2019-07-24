DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(20))
BEGIN
    SELECT first_name, last_name
    FROM employees 
    WHERE salary < 30000 AND salary_level = 'low'
        OR salary >= 30000 AND salary <= 50000 AND salary_level = 'average'
        OR salary > 50000 AND salary_level = 'high'
    ORDER BY first_name DESC, last_name DESC;
END
$$