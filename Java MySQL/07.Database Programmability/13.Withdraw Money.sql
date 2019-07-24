DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
	IF money_amount > 0 THEN
		START TRANSACTION;
        
        UPDATE accounts
        SET balance = balance - money_amount
        WHERE id = account_id;
        
        IF (SELECT balance FROM accounts
			WHERE id = account_id) < 0
            THEN ROLLBACK;
            ELSE COMMIT;
        END IF;
        
    END IF;
END
$$

CALL usp_withdraw_money(1, 10);

SELECT id AS 'account_id', account_holder_id, balance FROM accounts
WHERE id = 1;