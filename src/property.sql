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
 renter_id varchar(3) NOT NULL,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (renter_id)
 );
 
INSERT INTO RENTER (renter_id, name, email, password)
VALUES
('001',	'Mike Smith',	 'abc@gmail.com','123'),
('002',	'Christie Rhodes', 'pqr@gmail.com','cat'),
('003',	'Jibran Khan',	 'xyz@gmail.com','dog'),
('004',	'Nick Richards','stv@gmail.com','fish'),
('005',	'Anna Arch',	 'cry@gmail.com','rat');


 DROP TABLE IF EXISTS PROPERTY;
 CREATE TABLE PROPERTY
 (
 ID varchar(4) NOT NULL,
 address varchar(25),
 type varchar(25),
 dateListed date,
 paymentExpiry char(7),
 noOfBedrooms int,
 noOfBathrooms int,
 furnishing char(12),
 cityQuadrant char(2),
 price int,
 landlordID varchar(3),
 PRIMARY KEY (ID),
 FOREIGN KEY (landlordID)references LANDLORD(landlord_id) on UPDATE CASCADE
 );
 
INSERT INTO PROPERTY (ID, address, type, dateListed, paymentExpiry, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant, price, landLordID)
VALUES
('P100', '12 Sway Street', 'Apartment','2020-12-12','Due', 2,	1,	'Unfurnished',	'NE',	1000,	'001'),
('P101','934 Long rd', 'Attached',	'2021-01-13','Paid', 5,	4,	'Furnished',	'NW',	2000,	'003'),
('P102', '13 Nest cres', 'Detached',	'2020-11-03','Due', 5,	3,	'Unfurnished',	'SE',	1500,	'002'), 
('P103','29 43 Red Cresent', 'Townhouse','2018-12-21','Paid',3,	2,	'Furnished',	'SE',	1500,	'004'),
('P104', '4502 Charles Ave', 'Apartment','2021-11-20','Paid',3,	3,	'Furnished',    'SW',	1000,	'005'),
('P105', '43 Woods Place', 'Detached', '2021-07-01','Paid',  4,	4,	'Furnished',	'SW',	1500,	'002'),
('P106','201 Douglas Circle', 'Attached', '2019-05-30','Due', 6,	5,	'Unfurnished',	'NE',	4000,	'001'),
('P107','775 Cedar Drive', 'Townhouse','2020-05-31','Paid',6,	6,	'Furnished',	'SE',	5000,	'001'),
('P108','5656 Holy Street', 'Apartment','2021-02-11','Paid',1,	1,	'Furnished',	'NW',	400,	'005'),
('P109','7 Blue Drive', 'Detached', '2021-01-13','Due', 2,	2,	'Unfurnished',	'NE',	700,	'004'),
('P110', ' 69 Green Ave',	'Attached',	'2020-09-07','Paid',3,	3,	'Furnished',	'NE',	1500,	'003'),
('P111', '909 Planters Street', 'Detached', '2020-08-19','Due',7,	5,	'Furnished',	'SW',	5000,	'002'),
('P112', '39 Cran Circle', 'Apartment','2018-12-02','Paid',4,	4,	'Unfurnished',	'SE',	1250,	'004'),
('P113', '3 77 Front Street',	'Apartment','2019-11-07','Paid',5,	2,	'Furnished',	'NW',	1800,	'003'),
('P114', '98 Dog Blvd', 'Townhouse','2021-10-09','Paid',6,	6,	'Unfurnished',	'NE',	6500,	'005');


 DROP TABLE IF EXISTS PROPERTY_STATUS;
 CREATE TABLE PROPERTY_STATUS
 (
  property_id varchar(4) NOT NULL,
  oldStatus char(12) NOT NULL,
  newStatus char(12),
  dateUpdated date,
  PRIMARY KEY (property_id),
  FOREIGN KEY (property_id) references PROPERTY(ID) on UPDATE CASCADE
 );
INSERT INTO PROPERTY_STATUS (property_id, oldStatus, newStatus, dateUpdated)
VALUES
('P100','Active',NULL, NULL),
('P101','Active',NULL,NULL),
('P102','Listed','Rented','2021-01-01'), 
('P103','Listed','Cancelled','2020-10-20'),
('P104','Suspended','Active','2021-11-11'),
('P105','Active',NULL,NULL ),
('P106','Active',NULL,NULL),
('P107','Active','Rented','2021-05-31'),
('P108','Rented','Active','2021-11-12'),
('P109','Active',NULL,NULL),
('P110','Active','Cancelled','2021-10-10'),
('P111','Suspended','Cancelled','2021-07-10'),
('P112','Active',NULL,NULL),
('P113','Active',NULL,NULL),
('P114','Suspended','Active','2021-11-11');
