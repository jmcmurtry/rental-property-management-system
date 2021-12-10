package model;

/* 
 * Email.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Email {
    private int emailId;
    private int landlordID;
    private String renterEmail;
    private int propertyID;
    private String message;

    public Email(int email, int landlord, String renter, int property, String message){
        this.emailId = email;
        this.landlordID = landlord;
        this.renterEmail = renter;
        this.propertyID = property;
        this.message = message;
    }
    
	/**
	 * Getter method for emailID
	 * @return returns an int corresponding to the emailID
	 */

    public int getEmailId(){
        return this.emailId;
    }
    
	/**
	 * Getter method for landlordID
	 * @return returns an int corresponding to the landlordID
	 */

    public int getLandlordID(){
        return this.landlordID;
    }

	/**
	 * Getter method for the renter email
	 * @return returns a string corresponding to the renter's email address
	 */
    
    public String getRenterEmail(){
        return this.renterEmail;
    }

	/**
	 * Getter method for propertyID
	 * @return returns an int corresponding to the propertyID
	 */
    
    public int getPropertyID(){
        return this.propertyID;
    }

	/**
	 * Getter method for message
	 * @return returns a string corresponding to the message sent by the renter 
	 */
    
    public String getMessage(){
        return this.message;
    }
    
}

