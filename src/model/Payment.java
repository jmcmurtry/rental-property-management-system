package model;

/* 
 * Payment.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Payment {
    private int fee;
    private Date startDate;
    private Date endDate;
    private int registeredPropID;
    private int landlordID;

    public Payment(int fee, Date start, Date end, int propertyID, int landlordID){
    }

    public void setFee(int fee){
    }

    public void setStartDate(Date start){
    }

    public void setEndDate(Date end){
    }

    public int getFee(){
        return this.fee;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public int getPropertyID(){
        return this.registeredPropID;
    }

    public int getLandlordID(){
        return this.landlordID;
    }
}
