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
    
    /**
     * Constructor of thr Property class
     * @param id
     * @param address
     * @param type
     * @param bed
     * @param bath
     * @param furn
     * @param quad
     * @param ownerid
     * @param rentPrice
     * @param expiryDate
     * @param status
     */

    public Property(int id, String address, String type, int bed, int bath, boolean furn, String quad, int ownerid, int rentPrice, Date expiryDate, String status){
        this.id = id;
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

    /**
     * Setter of the type of Property
     * @param type
     */
    public void setType(String type){
        this.propertyType = type;
    }

    /**
     * Setter of the number of beds in a property
     * @param bed
     */
    public void setBed(int bed){
        this.noBed = bed;
    }
    
    /**
     * Setter of the number of bathrooms in a property
     * @param bath
     */
    public void setBath(int bath){
        this.noBath = bath;
    }

    /**
     * Setter of the boolean isFurnished in a property
     * @param furn
     */
    
    public void setFurnished(boolean furn){
        this.isFurnished = furn;
    }

    /**
     * Setter of the quadrant that the property belongs to
     * @param quad
     */
    
    public void setQuadrant(String quad){
        this.quadrant = quad;
    }

    /**
     * Method to change the LandlordID of a property
     * @param ownerId
     */
    
    public void changeLandlord(int ownerId){
        this.landlordID = ownerId;
    }

    /**
     * Method to change the paymentExpiry date of the Property listing
     * @param newExpiry
     */
    
    public void changePaymentExpiry(Date newExpiry){
        this.paymentExpiry = newExpiry;
    }

    /**
     * Setter of the status of a property
     * @param status
     */
    
    public void setStatus(String status){
        this.propertyStatus = status;
    }

    /**
     * Getter of the address of a property
     * @return a String corresponding to the address
     */
    
    public String getAddress(){
        return this.address;
    }

    /**
     * Getter of the type of thr property
     * @return a String corresponding to the propertyType
     */
    
    public String getType(){
        return this.propertyType;
    }

    /**
     * Getter of the number of bedrooms in a property
     * @return an int corresponding to the number of bedrooms
     */
    
    public int getBed(){
        return this.noBed;
    }
    
    /**
     * Getter of the number of bathrooms in a property
     * @return an int corresponding to the number of bathrooms
     */
    
    public int getBath(){
        return this.noBath;
    }

    /**
     * Getter of the furnishing of a property
     * @return a boolean corresponding to the furnishing of the property
     */
    
    public boolean getFurnished(){
        return this.isFurnished;
    }

    /**
     * Getter of the quadrant the property belogs to
     * @return a String corresponding to the quadrant
     */
    
    public String getQuadrant(){
        return this.quadrant;
    }

    /**
     * Getter of the propertyID
     * @return an int corresponding to the id
     */
    
    public int getID(){
        return this.id;
    }

    /**
     * Getter of the LandlordID of the property
     * @return an int corresponding to the lanlordID of the property
     */
    
    public int getLandlord(){
        return this.landlordID;
    }
 
    /**
     * Getter of the paymentExpiry date of a property
     * @return a Date corresponding to the expiryDate
     */
    
    public Date getPaymentExpiry(){
        return this.paymentExpiry;
    }

    /**
     * Getter of the rentPrice in a property
     * @return an int corresponding to the price of the property
     */
    
    public int getRentPrice(){
        return this.rentPrice;
    }

    /**
     * Getter of the status of the property
     * @return a String corresponding to the status of the Property
     */
    
    public String getStatus(){
        return this.propertyStatus;
    }
