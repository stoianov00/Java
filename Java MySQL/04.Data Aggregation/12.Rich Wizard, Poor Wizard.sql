SELECT SUM(hw.deposit_amount - gw.deposit_amount) AS 'sum_difference'
FROM wizzard_deposits AS hw, wizzard_deposits AS gw
WHERE gw.id - hw.id = 1;