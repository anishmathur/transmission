--
-- Sample dataset containing a number of Hotels in various Cities across the world.  The reviews are entirely fictional :)
--

-- =================================================================================================
-- AUSTRALIA

-- Brisbane
insert into transmission_line(name,capacity) values ('Northern',150)
insert into generation(name, generation_level, transmission_line_id) values ('KH1', 50.0, 1)
insert into generation(name, generation_level, transmission_line_id) values ('KH2', 50.0, 1)
insert into transmission_line(name,capacity) values ('Southern',100)
insert into generation(name, generation_level, transmission_line_id) values ('SD1', 20.0, 2)
