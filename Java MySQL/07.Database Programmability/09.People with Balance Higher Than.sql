DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance_parameter DECIMAL)
BEGIN	
	SELECT ah.first_name, ah.last_name FROM account_holders AS ah
    INNER JOIN accounts AS a
    ON a.account_holder_id = ah.id
	GROUP BY ah.id
    HAVING SUM(a.balance) >= balance_parameter
    ORDER BY a.id, ah.first_name, ah.last_name;
END
$$

CALL usp_get_holders_with_balance_higher_than(7000);