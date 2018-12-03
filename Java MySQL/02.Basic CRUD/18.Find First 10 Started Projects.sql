SELECT project_id, name AS 'Name', description AS 'Description', start_date, end_date FROM projects
ORDER BY start_date ASC, 
		 name ASC, 
         project_id ASC
LIMIT 10;