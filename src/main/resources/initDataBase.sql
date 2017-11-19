CREATE TABLE IF NOT EXISTS developers(
  id INT AUTO_INCREMENT NOT NULL UNIQUE ,
  first_name VARCHAR(40) NOT NULL ,
  second_name VARCHAR(40)NOT NULL,
  PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS skills(
  id INT AUTO_INCREMENT NOT NULL UNIQUE ,
  skill VARCHAR(100) NOT NULL,
  PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS projects(
  id INT AUTO_INCREMENT NOT NULL UNIQUE ,
  project_name VARCHAR(100) NOT NULL,
  project_description VARCHAR(100) NOT NULL,
  PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS companies(
  id INT AUTO_INCREMENT NOT NULL UNIQUE ,
  companie_name VARCHAR(100) NOT NULL,
  PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS developers_skills(
  developer_id INT NOT NULL,
  skill_id INT NOT NULL,
  PRIMARY KEY (developer_id ,skill_id)
);

CREATE TABLE IF NOT EXISTS developers_projects(
  developer_id INT NOT NULL,
  project_id INT NOT NULL,
  PRIMARY KEY (developer_id,project_id)
);

CREATE TABLE IF NOT EXISTS companies_projects(
  companie_id INT NOT NULL,
  project_id INT NOT NULL ,
  PRIMARY KEY (companie_id,project_id)
);

CREATE TABLE IF NOT EXISTS customers_projects(
  custumer_id INT NOT NULL ,
  project_id INT NOT NULL ,
  PRIMARY KEY (custumer_id,project_id)
);

CREATE TABLE IF NOT EXISTS customers(
  id INT AUTO_INCREMENT NOT NULL UNIQUE ,
  customer_name VARCHAR(100) NOT NULL,
  PRIMARY KEY( id )
);