package model;

import java.util.ArrayList;

/* 
 * SummaryReport.java
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

      /**
     * Constructor of the summaryReport class
     * @param listed
     * @param rented
     * @param active
     * @param houses
     */
    public SummaryReport(int listed, int rented, int active, ArrayList<Property> houses){
        this.totalListed = listed;
        this.totalRented = rented;
        this.totalActive = active;
        this.housesRented = houses;
    }

      /**
     * Setter of the total number of listed properties
     * @param listed
     */
    public void setTotalListed(int listed){
        this.totalListed = listed;
    }

     /**
     * Setter of the total number of properties rented
     * @param rented
     */
    public void setTotalRented(int rented){
        this.totalRented = rented;
    }

    /**
   * Setter of the total number of active properties 
   * @param active
   */
    public void setTotalActive(int active){
        this.totalActive = active;
    }

     /**
     * Setter of the Arraylist of houses rented
     * @param houses
     */
    public void setHousesRented(ArrayList<Property> houses){
        this.housesRented = houses;
    }
  
    /**
    * Getter of total number of properties listed
    * @return an int corresponding to the total number of properties listed
    */
    public int getTotalListed(){
        return this.totalListed;
    }

     /**
    * Getter of total number of properties rented
    * @return an int corresponding to the total number of properties rented
    */
    public int getTotalRented(){
        return this.totalRented;
    }

    /**
    * Getter of total number of properties active
    * @return an int corresponding to the total number of properties active
    */
    public int getTotalActive(){
        return this.totalActive;
    }
    /**
    * Getter of the info of properties active
    * @return an ArrayList of properties corresponding to all the properties rented
    */
    public ArrayList<Property> getHousesRented(){
        return this.housesRented;
    }
    
}
