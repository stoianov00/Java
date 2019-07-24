DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_number INT)
BEGIN
		SELECT first_name, last_name FROM employees
		WHERE salary >= salary_number
		ORDER BY first_name, last_name, employee_id;
END
$$

CALL usp_count_employees_by_town_name(48100);