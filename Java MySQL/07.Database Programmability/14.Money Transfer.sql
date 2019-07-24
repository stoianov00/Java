DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
		IF amount > 0 
        AND from_account_id <> to_account_id 
        AND (SELECT id 
            FROM accounts
            WHERE id = to_account_id) IS NOT NULL
        AND (SELECT id 
            FROM accounts
            WHERE id = from_account_id) IS NOT NULL
        AND (SELECT balance 
            FROM accounts 
            WHERE id = from_account_id) >= amount
		THEN
			START TRANSACTION;
            
            UPDATE accounts
            SET balance = balance + amount
            WHERE id = to_account_id;
            
			UPDATE accounts
            SET balance = balance - amount
            WHERE id = from_account_id;
			
            IF (SELECT balance 
				FROM accounts  
				WHERE id = from_account_id) < 0
				THEN ROLLBACK;
			ELSE
				COMMIT;
			END IF;
            
        END IF;
END
$$

CALL usp_transfer_money(1, 2, 10);
CALL usp_transfer_money(2, 1, 10);

SELECT 
    id AS 'account_id', account_holder_id, balance
FROM
    accounts
WHERE
    a.id IN (1 , 2);
