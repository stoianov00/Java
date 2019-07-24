DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(town_start VARCHAR(50))
BEGIN
	SELECT name FROM towns
    WHERE SUBSTRING(name, 1, CHAR_LENGTH(town_start)) = town_start
    ORDER BY name;
END
$$

CALL usp_get_towns_starting_with('b'); 