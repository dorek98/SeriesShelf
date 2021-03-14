create database if not exists series_shelf;

use series_shelf;

drop table if exists actor;

CREATE TABLE actor (
  actor_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(64) NOT NULL,
  last_name varchar(64) NOT NULL,
  age int NOT NULL,
  PRIMARY KEY (actor_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists series;

CREATE TABLE series (
  series_id int NOT NULL AUTO_INCREMENT,
  title varchar(64) NOT NULL,
  numberOfSeasons int NOT NULL,
  platform  varchar(64) NOT NULL,
  yearOfPremiere int NOT NULL,
  PRIMARY KEY (series_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists `role`;

CREATE TABLE `role` (
  role_id int NOT NULL AUTO_INCREMENT,
  role_name  varchar(64) NOT NULL,
  series_id int NOT NULL,
  actor_id int NOT NULL,
  PRIMARY KEY (role_id),
  FOREIGN KEY(series_id) REFERENCES series(series_id),
  FOREIGN KEY(actor_id) REFERENCES actor(actor_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists shelf;

CREATE TABLE shelf (
  shelf_id int NOT NULL AUTO_INCREMENT,
  title varchar(64) NOT NULL,
  PRIMARY KEY (shelf_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


drop table if exists seriesList;

CREATE TABLE seriesList (
  shelf_id int NOT NULL,
  series_id int NOT NULL,
  PRIMARY KEY (shelf_id, series_id),
  FOREIGN KEY(shelf_id) REFERENCES shelf(shelf_id),
  FOREIGN KEY(series_id) REFERENCES series(series_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO actor (first_name, last_name, age) VALUES 
('Kit','Harington',34),('Sean','Bean',61),('Peter','Dinklage',51),
('Ursula','Corbero',31),('Pedro','Alonso',49),
('Jennifer','Connelly',50),('Daveed','Diggs',39);

INSERT INTO series (title, numberOfSeasons, platform, yearOfPremiere) VALUES 
('Game of Thrones',8,'HBO',2011),('Snowpiercer',2,'NETFLIX',2020),('La casa de papel',4,'NETFLIX',2017) ;

INSERT INTO `role` (role_name, series_id, actor_id) 
VALUES ('Jon Snow',1,1),('Eddard Stark',1,2),('Tyrion Lannister',1,3),
('Tokio',3,4),('Berlin',3,5),
('Melanie Cavill',2,6),('Andre Layton',2,7),('Wilford',2,2);

INSERT INTO shelf (title) VALUES ('Test');

INSERT INTO seriesList VALUES (1,1);



