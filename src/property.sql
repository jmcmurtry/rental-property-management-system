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
 

 DROP TABLE IF EXISTS PROPERTY_STATUS;
 CREATE TABLE PROPERTY_STATUS
 (
  property_id int NOT NULL,
  status char(12) NOT NULL,
  PRIMARY KEY (property_id),
  FOREIGN KEY (property_id) references PROPERTY(ID) on UPDATE CASCADE
 );

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
  subrenter_id int,
  type varchar(25);
  noOfBedrooms int,
  noOfBathrooms int,
  furnishing boolean,
  cityQuadrant char(2),
  PRIMARY KEY (table_ID),
  FOREIGN KEY (subrenter_id) references Renter(renter_id) on Update CASCADE
 );
