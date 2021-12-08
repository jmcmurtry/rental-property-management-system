DROP DATABASE IF EXISTS PROPERTY;
CREATE DATABASE PROPERTY; 
USE PROPERTY;
 
 DROP TABLE IF EXISTS LANDLORD;
 CREATE TABLE LANDLORD
 (
 landlord_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (landlord_id)
 );

INSERT INTO LANDLORD (name, email, password)
VALUES
('John Clooney', 'abc@gmail.com', ' 123'),
('Harrison Pitt', 'pqr@gmail.com', 'cat'),
('Athena Bond','xyz@gmail.com', 'dog'),
('Sarthak Sharan','stv@gmail.com', 'hello'),
('Leo Caprio', 'cry@gmail.com', 'worm');


DROP TABLE IF EXISTS MANAGER;
 CREATE TABLE MANAGER
 (
 manager_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (manager_id)
 );

INSERT INTO MANAGER (name, email, password)
VALUES
('John Clooney', 'abc@gmail.com', '123'),
('Harrison Pitt', 'pqr@gmail.com', 'cat'),
('Athena Bond',	'xyz@gmail.com', 'dog'),
('Sarthak Sharan','stv@gmail.com', 'hello'),
('Leo Caprio', 'cry@gmail.com', 'worm');

 DROP TABLE IF EXISTS RENTER;
 CREATE TABLE RENTER
 (
 renter_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (renter_id)
 );
 
INSERT INTO RENTER (name, email, password)
VALUES
('Mike Smith','abc@gmail.com','123'),
('Christie Rhodes', 'pqr@gmail.com','cat'),
('Jibran Khan', 'xyz@gmail.com','dog'),
('Nick Richards','stv@gmail.com','fish'),
('Anna Arch', 'cry@gmail.com','rat');


 DROP TABLE IF EXISTS PROPERTY;
 CREATE TABLE PROPERTY
 (
 ID int NOT NULL auto_increment,
 address varchar(25),
 type varchar(25),
 dateListed date,
 paymentExpiry char(12),
 noOfBedrooms int,
 noOfBathrooms int,
 furnishing boolean,
 cityQuadrant char(2),
 landlordID int,
 price int,
 PRIMARY KEY (ID),
 FOREIGN KEY (landlordID)references LANDLORD(landlord_id) on UPDATE CASCADE
 );
 
INSERT INTO PROPERTY (address, type, dateListed, paymentExpiry, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant, price, landLordID)
VALUES
('12 Sway Street', 'Apartment','2020-12-12','Due', 2,	1,	'Unfurnished',	'NE',	1000,	'1'),
('934 Long rd', 'Attached',	'2021-01-13','Paid', 5,	4,	'Furnished',	'NW',	2000,	'3'),
('13 Nest cres', 'Detached',	'2020-11-03','Due', 5,	3,	'Unfurnished',	'SE',	1500,	'2'), 
('29 43 Red Cresent', 'Townhouse','2018-12-21','Paid',3,	2,	'Furnished',	'SE',	1500,	'4'),
('4502 Charles Ave', 'Apartment','2021-11-20','Paid',3,	3,	'Furnished',    'SW',	1000,	'5'),
('43 Woods Place', 'Detached', '2021-07-01','Paid',  4,	4,	'Furnished',	'SW',	1500,	'2'),
('201 Douglas Circle', 'Attached', '2019-05-30','Due', 6,	5,	'Unfurnished',	'NE',	4000,	'1'),
('775 Cedar Drive', 'Townhouse','2020-05-31','Paid',6,	6,	'Furnished',	'SE',	5000,	'1'),
('5656 Holy Street', 'Apartment','2021-02-11','Paid',1,	1,	'Furnished',	'NW',	400,	'5'),
('7 Blue Drive', 'Detached', '2021-01-13','Due', 2,	2,	'Unfurnished',	'NE',	700,	'4'),
('69 Green Ave',	'Attached',	'2020-09-07','Paid',3,	3,	'Furnished',	'NE',	1500,	'3'),
('909 Planters Street', 'Detached', '2020-08-19','Due',7,	5,	'Furnished',	'SW',	5000,	'2'),
('39 Cran Circle', 'Apartment','2018-12-02','Paid',4,	4,	'Unfurnished',	'SE',	1250,	'4'),
('3 77 Front Street',	'Apartment','2019-11-07','Paid',5,	2,	'Furnished',	'NW',	1800,	'3'),
('98 Dog Blvd', 'Townhouse','2021-10-09','Paid',6,	6,	'Unfurnished',	'NE',	6500,	'5');


 DROP TABLE IF EXISTS PROPERTY_STATUS;
 CREATE TABLE PROPERTY_STATUS
 (
  property_id int NOT NULL,
  oldStatus char(12) NOT NULL,
  newStatus char(12),
  dateUpdated date,
  PRIMARY KEY (property_id),
  FOREIGN KEY (property_id) references PROPERTY(ID) on UPDATE CASCADE
 );
INSERT INTO PROPERTY_STATUS (property_id, oldStatus, newStatus, dateUpdated)
VALUES
('1','Active',NULL,NULL),
('2','Listed','Rented','2021-01-01'), 
('3','Listed','Cancelled','2020-10-20'),
('4','Suspended','Active','2021-11-11'),
('5','Active',NULL,NULL ),
('6','Active',NULL,NULL),
('7','Active','Rented','2021-05-31'),
('8','Rented','Active','2021-11-12'),
('9','Active',NULL,NULL),
('10','Active','Cancelled','2021-10-10'),
('11','Suspended','Cancelled','2021-07-10'),
('12','Active',NULL,NULL),
('13','Active',NULL,NULL),
('14','Suspended','Active','2021-11-11');
