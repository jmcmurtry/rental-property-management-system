package model;

import java.sql.Date;

/* 
 * Property.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Property {
    private int id;
    private String address;
    private String propertyType;
    private int noBed;
    private int noBath;
    private boolean isFurnished;
    private String quadrant; 
    private int landlordID;
    private int rentPrice;
    private Date paymentExpiry;
    private String propertyStatus;

    public Property(String address, String type, int bed, int bath, boolean furn, String quad, int ownerid, int rentPrice, Date expiryDate, String status){
        this.address = address;
        this.propertyType = type;
        this.noBed = bed;
        this.noBath = bath;
        this.isFurnished = furn;
        this.quadrant = quad;
        this.landlordID = ownerid;
        this.rentPrice = rentPrice;
        this.paymentExpiry = expiryDate;
        this.propertyStatus = status;
    }

    public void setType(String type){
        this.propertyType = type;
    }

    public void setBed(int bed){
        this.noBed = bed;
    }
    
    public void setBath(int bath){
        this.noBath = bath;
    }

    public void setFurnished(boolean furn){
        this.isFurnished = furn;
    }

    public void setQuadrant(String quad){
        this.quadrant = quad;
    }

    public void changeLandlord(int ownerId){
        this.landlordID = ownerId;
    }

    public void changePaymentExpiry(Date newExpiry){
        this.paymentExpiry = newExpiry;
    }

    public void setStatus(String status){
        this.propertyStatus = status;
    }

    public String getAddress(){
        return this.address;
    }

    public String getType(){
        return this.propertyType;
    }

    public int getBed(){
        return this.noBed;
    }
    
    public int getBath(){
        return this.noBath;
    }

    public boolean getFurnished(){
        return this.isFurnished;
    }

    public String getQuadrant(){
        return this.quadrant;
    }

    public int getID(){
        return this.id;
    }

    public int getLandlord(){
        return this.landlordID;
    }

    public Date getPaymentExpiry(){
        return this.paymentExpiry;
    }

    public int getRentPrice(){
        return this.rentPrice;
    }

    public String getStatus(){
        return this.propertyStatus;
    }
}
