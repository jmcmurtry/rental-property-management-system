package model;

import java.util.ArrayList;

/* 
 * Subject.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class SummaryReport {
    private int totalListed;
    private int totalRented;
    private int totalActive;
    private ArrayList<Property> housesRented;

    public SummaryReport(int listed, int rented, int active, ArrayList<Property> houses){
        this.totalListed = listed;
        this.totalRented = rented;
        this.totalActive = active;
        this.housesRented = houses;
    }

    public void setTotalListed(int listed){
        this.totalListed = listed;
    }

    public void setTotalRented(int rented){
        this.totalRented = rented;
    }

    public void setTotalActive(int active){
        this.totalActive = active;
    }

    public void setHousesRented(ArrayList<Property> houses){
        this.housesRented = houses;
    }

    public int getTotalListed(){
        return this.totalListed;
    }

    public int getTotalRented(){
        return this.totalRented;
    }

    public int getTotalActive(){
        return this.totalActive;
    }

    public ArrayList<Property> getHousesRented(){
        return this.housesRented;
    }
    
}
