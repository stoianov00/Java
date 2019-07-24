DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DOUBLE, yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS DOUBLE
DETERMINISTIC
BEGIN
	DECLARE future_value_sum DOUBLE;
    SET future_value_sum := initial_sum * POW((1 + yearly_interest_rate), number_of_years);
    
    RETURN future_value_sum;	
END
$$

SELECT ufn_calculate_future_value(1000, 0.1, 5);