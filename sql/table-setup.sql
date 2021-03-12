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

drop table if exists roles;

CREATE TABLE roles (
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



INSERT INTO actor (first_name, last_name, age) VALUES ('Kit','Harington',34);
INSERT INTO actor (first_name, last_name, age) VALUES ('Sean','Bean',61);
INSERT INTO actor (first_name, last_name, age) VALUES ('Peter','Dinklage',51);

INSERT INTO actor (first_name, last_name, age) VALUES ('Ursula','Corbero',31);
INSERT INTO actor (first_name, last_name, age) VALUES ('Pedro','Alonso',49);

INSERT INTO actor (first_name, last_name, age) VALUES ('Jennifer','Connelly',50);
INSERT INTO actor (first_name, last_name, age) VALUES ('Daveed','Diggs',39);


INSERT INTO series (title, numberOfSeasons, platform, yearOfPremiere) VALUES ('Game of Thrones',8,'HBO',2011);
INSERT INTO series (title, numberOfSeasons, platform, yearOfPremiere) VALUES ('Snowpiercer',2,'NETFLIX',2020);
INSERT INTO series (title, numberOfSeasons, platform, yearOfPremiere) VALUES ('La casa de papel',4,'NETFLIX',2017);

INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Jon Snow',1,1);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Eddard Stark',1,2);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Tyrion Lannister',1,3);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Tokio',3,4);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Berlin',3,5);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Melanie Cavill',2,6);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Andre Layton',2,7);
INSERT INTO roles (role_name, series_id, actor_id) VALUES ('Wilford',2,2);

INSERT INTO shelf (title) VALUES ('Test');

INSERT INTO seriesList VALUES (1,1);



