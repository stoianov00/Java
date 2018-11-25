USE minions;

ALTER TABLE minions
ADD town_id INT(11);

ALTER TABLE minions
ADD CONSTRAINT FOREIGN KEY fk_town_id(town_id) REFERENCES towns(id);