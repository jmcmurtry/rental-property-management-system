DROP DATABASE IF EXISTS PROPERTY_MANAGEMENT;
CREATE DATABASE PROPERTY_MANAGEMENT; 
USE PROPERTY_MANAGEMENT;
 
 DROP TABLE IF EXISTS Landlord;
 CREATE TABLE Landlord
 (
 landlord_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (landlord_id),
 CONSTRAINT unique_email UNIQUE (email)
 );

INSERT INTO Landlord(name, email, password)
VALUES
('Nick Richards','stv@gmail.com','fish'),
('Harrison Pitt', 'pqr@gmail.com', 'cat'),
('Mike Smith','abc@gmail.com','123');


 DROP TABLE IF EXISTS Manager;
 CREATE TABLE Manager
 (
 manager_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (manager_id),
 CONSTRAINT unique_email UNIQUE (email)
 );

INSERT INTO Manager (name, email, password)
VALUES
('John Clooney', 'abc@gmail.com', '123'),
('Harrison Pitt', 'pqr@gmail.com', 'cat'),
('Athena Bond',	'xyz@gmail.com', 'dog'),
('Sarthak Sharan','stv@gmail.com', 'hello'),
('Leo Caprio', 'cry@gmail.com', 'worm');


 DROP TABLE IF EXISTS Renter;
 CREATE TABLE Renter
 (
 renter_id int NOT NULL auto_increment,
 name varchar(25),
 email varchar(25),
 password char(25),
 PRIMARY KEY (renter_id),
 CONSTRAINT unique_email UNIQUE (email)
 );

INSERT INTO Renter(name, email, password)
VALUES
('Gary Jones','gargar@gmail.com','hi'),
('Mikey Lee', 'mikey@gmail.com', 'dog'),
('Katie Rox','kr@gmail.com','cat');


 DROP TABLE IF EXISTS PROPERTY;
 CREATE TABLE PROPERTY
 (
 ID int NOT NULL auto_increment,
 address varchar(25),
 type varchar(25),
 paymentExpiry  date,
 status char(12) NOT NULL,
 noOfBedrooms int,
 noOfBathrooms int,
 furnishing boolean,
 cityQuadrant char(2),
 price int,
 landlordID int NOT NULL,
 PRIMARY KEY (ID),
 FOREIGN KEY (landlordID)references LANDLORD(landlord_id) on UPDATE CASCADE
 );

INSERT INTO PROPERTY (address, type, paymentExpiry, status, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant, price, landLordID)
VALUES
('69 Green Ave','Townhouse','2020-09-07','Active', 3,	2,	0,	'NE',	1500,	1),
('909 Planters Street','House', '2020-08-19','Suspended',2,	1,	1,	'SW',	5000,	3),
('39 Cran Circle', 'Apartment','2018-12-02','Active',4,	3,	0,	'SE',	1250,	2),
('3 77 Front Street','Apartment','2019-11-07','Rented',3, 2,	0,	'NW',	1800,	2),
('98 Dog Blvd', 'Townhouse','2021-10-09','Cancelled',4, 1,	1,	'NE',	6500,	1);
 
 
 DROP TABLE IF EXISTS FEE_INFO;
 CREATE TABLE FEE_INFO
 (
  id ENUM('1') NOT NULL,
  fee double NOT NULL,
  numDays int NOT NULL,
  PRIMARY KEY (id)
 );
 
 INSERT INTO fee_info(fee, numDays) 
 VALUES (30, 60);
 
 DROP TABLE IF EXISTS subscribed_renters;
 CREATE TABLE subscribed_renters
 (
  table_ID int NOT NULL auto_increment,
  subrenter_email varchar(25) NOT NULL,
  type varchar(25),
  noOfBedrooms int,
  noOfBathrooms int,
  furnishing boolean,
  cityQuadrant char(2),
  PRIMARY KEY (table_ID),
  FOREIGN KEY (subrenter_email) references Renter(email) on Update CASCADE,
  CONSTRAINT unique_renter UNIQUE (subrenter_email)
 );

 DROP TABLE IF EXISTS EMAIL;
 CREATE TABLE EMAIL
 (
  email_id int NOT NULL auto_increment,
  landlordID int NOT NULL,
  renterEmail varchar(25) NOT NULL,
  propertyID int NOT NULL,
  message char(120) NOT NULL,
  PRIMARY KEY (email_id),
  FOREIGN KEY (landlordID)references LANDLORD(landlord_id) on UPDATE CASCADE,
  FOREIGN KEY (renterEmail)references RENTER(email) on UPDATE CASCADE,
  FOREIGN KEY (propertyID) references PROPERTY(ID) on UPDATE CASCADE
 );