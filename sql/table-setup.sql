create database if not exists seriesshelf;

use seriesshelf;

drop table if exists actors;

CREATE TABLE actors (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(64) DEFAULT NULL,
  surname varchar(64) DEFAULT NULL,
  age int(3) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists series;

CREATE TABLE series (
  title varchar(64) NOT NULL,
  numberOfSeasons int(3) DEFAULT NULL,
  platform  varchar(64) DEFAULT NULL,
  yearOfPremiere int(4) DEFAULT NULL,
  PRIMARY KEY (title)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists series;

CREATE TABLE roles (
  title varchar(64) NOT NULL,
  roleName  varchar(64) DEFAULT NULL,
  actorid int(11) DEFAULT NULL,
  PRIMARY KEY (roleName),
  FOREIGN KEY(title) REFERENCES series(title) ON DELETE SET NULL,
  FOREIGN KEY(actorid) REFERENCES actors(id) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists shelfs;

CREATE TABLE shelfs (
  title varchar(64) NOT NULL,
  PRIMARY KEY (title)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


drop table if exists seriesList;

CREATE TABLE seriesList (
  shelfTitle varchar(64) NOT NULL,
  seriesTitle varchar(64) NOT NULL,
  PRIMARY KEY (shelfTitle),
  FOREIGN KEY(shelfTitle) REFERENCES series(title) ON DELETE SET NULL,
  FOREIGN KEY(seriesTitle) REFERENCES series(title) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (1,'Doe','John','john.doe@foo.com', 'HR', 55000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (2,'Public','Mary','mary.public@foo.com', 'Engineering', 75000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (3,'Queue','Susan','susan.queue@foo.com', 'Legal', 130000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (4,'Williams','David','david.williams@foo.com', 'HR', 120000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (5,'Johnson','Lisa','lisa.johnson@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (6,'Smith','Paul','paul.smith@foo.com', 'Legal', 100000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (7,'Adams','Carl','carl.adams@foo.com', 'HR', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (8,'Brown','Bill','bill.brown@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (9,'Thomas','Susan','susan.thomas@foo.com', 'Legal', 80000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (10,'Davis','John','john.davis@foo.com', 'HR', 45000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (11,'Fowler','Mary','mary.fowler@foo.com', 'Engineering', 65000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (12,'Waters','David','david.waters@foo.com', 'Legal', 90000.00);
