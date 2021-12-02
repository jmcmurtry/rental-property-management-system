package model;

/* 
 * Subject.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Property {
    private String propertyType;
    private int noBed;
    private int noBath;
    private boolean isFurnished;
    private String quadrant;
    private int landlordID;
    private int id;
    private Payment paymentInfo; 


    public Property(String type, int bed, int bath, boolean furn, String quad, int ownerid){
    }

    public void setType(String type){
    }

    public void setBed(int bed){
    }

    public void setBath(int bath){
    }

    public void setFurnished(boolean furn){
    }

    public void setQuadrant(String quad){
    }

    public void changeLandlord(int onwerId){
    }

    public void changePayment(Payment newPayment){
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

    public Payment getPayment(){
        return this.paymentInfo;
    }

}

