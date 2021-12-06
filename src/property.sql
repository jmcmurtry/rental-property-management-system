DROP DATABASE IF EXISTS PROPERTY;
CREATE DATABASE PROPERTY; 
USE PROPERTY;
 
 DROP TABLE IF EXISTS LANDLORD;
 CREATE TABLE LANDLORD
 (
 LANDLORD_ID varchar(3) NOT NULL,
 NAME varchar(25),
 EMAIL varchar(25),
 PROVINCE char(2),
 PRIMARY KEY (LANDLORD_ID)
 );

INSERT INTO LANDLORD (LandLord_ID, Name, Email, Province)
VALUES
('001',	'John Clooney',	 'abc@gmail.com','BC'),
('002',	'Harrison Pitt', 'pqr@gmail.com','AB'),
('003',	'Athena Bond',	 'xyz@gmail.com','ON'),
('004',	'Sarthak Sharan','stv@gmail.com','SK'),
('005',	'Leo Caprio',	 'cry@gmail.com','AB');

 DROP TABLE IF EXISTS PROPERTY;
 CREATE TABLE PROPERTY
 (
 ID varchar(4) NOT NULL,
 Type varchar(25),
 DateListed date,
 PaymentExpiry char(7),
 NoOfBedrooms int,
 NoOfBathrooms int,
 Furnishing char(12),
 CityQuadrant char(2),
 Price int,
 LandLordID varchar(3),
 PRIMARY KEY (ID),
 FOREIGN KEY (LANDLORDID)references LANDLORD(LANDLORD_ID) on UPDATE CASCADE
 );
 
INSERT INTO PROPERTY (ID, Type,DateListed, PaymentExpiry, NoOfBedrooms, NoOfBathrooms, Furnishing, CityQuadrant, Price, LandLordID)
VALUES
('P100',	'Apartment','2020-12-12','Due', 2,	1,	'Unfurnished',	'NE',	1000,	'001'),
('P101',	'Attached',	'2021-01-13','Paid', 5,	4,	'Furnished',	'NW',	2000,	'003'),
('P102',	'Detached',	'2020-11-03','Due', 5,	3,	'Unfurnished',	'SE',	1500,	'002'), 
('P103',	'Townhouse','2018-12-21','Paid',3,	2,	'Furnished',	'SE',	1500,	'004'),
('P104',	'Apartment','2021-11-20','Paid',3,	3,	'Furnished',    'SW',	1000,	'005'),
('P105',	'Detached', '2021-07-01','Paid',  4,	4,	'Furnished',	'SW',	1500,	'002'),
('P106',	'Attached', '2019-05-30','Due', 6,	5,	'Unfurnished',	'NE',	4000,	'001'),
('P107',	'Townhouse','2020-05-31','Paid',6,	6,	'Furnished',	'SE',	5000,	'001'),
('P108',	'Apartment','2021-02-11','Paid',1,	1,	'Furnished',	'NW',	400,	'005'),
('P109',	'Detached', '2021-01-13','Due', 2,	2,	'Unfurnished',	'NE',	700,	'004'),
('P110',	'Attached',	'2020-09-07','Paid',3,	3,	'Furnished',	'NE',	1500,	'003'),
('P111',	'Detached', '2020-08-19','Due',7,	5,	'Furnished',	'SW',	5000,	'002'),
('P112',	'Apartment','2018-12-02','Paid',4,	4,	'Unfurnished',	'SE',	1250,	'004'),
('P113',	'Apartment','2019-11-07','Paid',5,	2,	'Furnished',	'NW',	1800,	'003'),
('P114',	'Townhouse','2021-10-09','Paid',6,	6,	'Unfurnished',	'NE',	6500,	'005');

 DROP TABLE IF EXISTS RENTER;
 CREATE TABLE RENTER
 (
 RENTER_ID varchar(3) NOT NULL,
 Name varchar(25),
 Email varchar(25),
 Province char(2),
 PRIMARY KEY (RENTER_ID)
 );
 
 INSERT INTO RENTER (Renter_ID, Name, Email,Province)
VALUES
('001',	'Mike Smith',	 'abc@gmail.com','BC'),
('002',	'Christie Rhodes', 'pqr@gmail.com','AB'),
('003',	'Jibran Khan',	 'xyz@gmail.com','ON'),
('004',	'Nick Richards','stv@gmail.com','SK'),
('005',	'Anna Arch',	 'cry@gmail.com','AB');

 DROP TABLE IF EXISTS PROPERTYSTATUS;
 CREATE TABLE PROPERTYSTATUS
 (
  PROPERTY_ID varchar(4) NOT NULL,
  OldStatus char(12) NOT NULL,
  NewStatus char(12),
  DateUpdated date,
  PRIMARY KEY (PROPERTY_ID),
  FOREIGN KEY (PROPERTY_ID) references PROPERTY(ID) on UPDATE CASCADE
 );
INSERT INTO PROPERTYSTATUS (PROPERTY_ID, OldStatus, NewStatus, DateUpdated)
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
