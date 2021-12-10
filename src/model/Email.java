package model;

/* 
 * Landlord.java
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
    private String renterName;
    private int propertyID;
    private String message;

    public Email(int email, int landlord, String renter, int property, String message){
        this.emailId = email;
        this.landlordID = landlord;
        this.renterName = renter;
        this.propertyID = property;
        this.message = message;
    }

    public int getEmailId(){
        return this.emailId;
    }

    public int getLandlordID(){
        return this.landlordID;
    }

    public String getRenterName(){
        return this.renterName;
    }

    public int getPropertyID(){
        return this.propertyID;
    }

    public String getMessage(){
        return this.message;
    }
    
}
