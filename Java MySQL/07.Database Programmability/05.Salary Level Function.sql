DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary_of_employee DECIMAL)
RETURNS VARCHAR(20)
BEGIN
	RETURN (
    SELECT
        CASE 
			WHEN salary_of_employee < 30000 THEN 'Low'
            WHEN salary_of_employee BETWEEN 30000 AND 50000 THEN 'Average'
            WHEN salary_of_employee > 50000 THEN 'High'
		END AS 'salary_level'
	);
END
$$

SELECT ufn_get_salary_level('13500.00');
SELECT ufn_get_salary_level('43300.00');
SELECT ufn_get_salary_level('125500.00');