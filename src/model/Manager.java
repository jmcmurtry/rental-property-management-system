package model;

/* 
 * Manager.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */


public class Manager extends UserProfile{

    public Manager(String email, String pswd){
        super(email, pswd);
    }

    public void changeListingState(String newState, int propertyID){
    }

    public void changeFees(int newFee, Property p){
    }

    public void changePeriod(Date start, Date end, Property p){
    }

    public SummaryReport generateReport(Date start, Date end){
    }

}
