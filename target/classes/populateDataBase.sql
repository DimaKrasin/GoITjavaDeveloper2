INSERT INTO developers (first_name, second_name) VALUES
  ('Dima', 'Krasin'),
  ('Sasha', 'Komarov'),
  ('David', 'Korniychuk'),
  ('Bogdan', 'Vovchuk');

INSERT INTO skills (skill) VALUES
  ('Java developer'),
  ('Know Scrum'),
  ('C++ developer'),
  ('Speak Japanese');

INSERT INTO projects (project_name, project_description) VALUES
  ('create a new social network', 'take best features from popular sn'),
  ('a logistic app', 'create logistic app to pizza delivery company'),
  ('system for SpaceX', 'create system that will make Ilon Mask rich'),
  ('mp8 player', ' create new format and player for it'),
  ('make robots great again','create new Ai with one purpose -  exterminate humanity'),
  ('computer game','make the most bloodfull game ever!');

INSERT INTO companies (companie_name) VALUES
  ('GoIT'), ('SpaceX'), ('Razer'), ('Apple');

INSERT INTO customers (customer_name) VALUES
  ('National Geographic Club'),
  ('Ivanov.Inc'),
  ('Anonymous'),
  ('Simple man');

INSERT INTO developers_skills (developer_id, skill_id) VALUES
  (1, 1),
  (1, 2),
  (1, 4),
  (2, 3),
  (2, 4),
  (3, 2),
  (3, 4),
  (4, 1);

INSERT INTO developers_projects (developer_id, project_id) VALUES
  (1,1),
  (1,2),
  (2,1),
  (3,1),
  (3,2),
  (3,3);

INSERT INTO companies_projects (companie_id, project_id) VALUES
  (1,1),
  (2,2),
  (2,3),
  (3,4),
  (4,5),
  (4,6);

INSERT INTO customers_projects(custumer_id, project_id) VALUES
  (1,1),
  (1,2),
  (2,3),
  (3,4),
  (4,5),
  (4,6);