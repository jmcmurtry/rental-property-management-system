# ENSF 480 Final Project - Online Rental Property Management System (Group 17)

## Contributors
John McMurtry <br /> 
Athena McNeil-Roberts <br /> 
Arindam Mishra <br /> 
Harrison Mondragon <br />

## Problem Description
Let’s assume you have been hired by a company to analyse, design, and develop an online Property Rental
Management System (PRMS) that its minimal requirements include:
• RQ1: Landlords should be able to register their properties using this online application. Once their property
is registered they should be able to pay certain fee and make their property posted online and be available ro
renters to view it. The fee is certain amount in dollars for a fixed period of time (example 60 days).

• RQ2: Regular renters don't need to login, and should be able to enter their search criteria such as:
  o Apartment, attached/detached house, townhouse, etc.
  o Number of bedrooms,
  o Number of bathrooms
  o Furnished/unfurnished
  o City quadrant: SW, NW, NE, SE
  
• RQ3: Registered renters, must first login. This group of renters, in addition previous functionalities for regular
renters, will have the privilege of being notified, when new listings is posted that matches their search criteria.
Also, they should be to unsubscribe at any time.

• RQ4: Renters who need further details should be able to send email to the landlord without seeing the
landlord’s name, or landlord’s email address.

• RQ5: Renters who are interested in property should be able to send email to landlord to arrange a meeting to
view the property, and possibly sign a contract. Note: Your system will only provide email communication
between renters and landlord, and doesn't do anything with signing the contract and rest of the details.

• RQ6: Managers should be able to login in, set or change the amount and period of fees, and should have a full
access to the renters, landlords, and properties information via company’s database system, which can be
some sort of light database. Please notice your application need to access this database engine to save or
retrieve properties, and registered customers, and landlord.

• RQ7: Mangers should be able to ask for a periodical summary report that shows: 
  o Total number of houses listed in the period. Notice that some houses that are listed may not be active
    anymore. It means some houses their posting period can be expired or landlords have cancelled their
    posting, therefore the renters cannot view them anymore.
  o Total number of houses rented in the period
  o Total number of active listing.
  o List of houses rented in the period. Which displays, the landlord’s name, the house’s id number,
    followed by its address.
    
• RQ8: Managers and Landlords should be able to change the state of a listing, from active, to rented, cancelled,
or suspended.

• RQ9: The system needs to have flexibility for future changes

• RQ10: Other requirements, as might be discovered during development process.


## To Run
In Terminal:
1. Clone entire directory to a new desktop folder.
2. Add to this folder a lib folder containing MySQL connector files.
3. In the console, direct to the desktop folder using cd < filepath >
4. To compile: <br /> 
  on mac: use command --> javac -cp .:lib/mysql-connector-java-8.0.23.jar:. controller/*.java view/*.java model/*.java App.java <br/> 
  on windows: use command --> javac -cp .;mysql-connector-java-8.0.23.jar;. controller/*.java view/*.java model/*.java App.java
5. To run: <br /> 
  on mac: use command --> java -cp .:lib/mysql-connector-java-8.0.23.jar:. App <br/> 
  on windows: use command --> java -cp .;mysql-connector-java-8.0.23.jar;. App

## Requirements
JDK <br /> 
MySQL
 - Download MySQL at : <https://dev.mysql.com/doc/mysql-getting-started/en/>
 - Download connector files at : <https://dev.mysql.com/downloads/connector/j/>

## UML Diagram
