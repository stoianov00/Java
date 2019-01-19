SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON r.id = cr.river_id
        INNER JOIN
    continents AS cn ON cn.continent_code = c.continent_code
WHERE
    cn.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;