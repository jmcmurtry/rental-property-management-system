package controller;
/* 
 * SummaryReportController.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

import java.sql.*;
import model.*;
import java.util.ArrayList;
public class SummaryReportController extends AppController{
    
    /**
    * Constructor - allows access to database
    */
    public SummaryReportController(){
        super();
    }

    /**
    * Retrieves the total number of properties in the database
    * @return : returns an int of all listed
    */
    public int getTotalListed(){
        int totalListed = 0;
        try{
            String query = "SELECT * FROM property";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                totalListed++;
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalListed;
    }

    /**
    * Retrieves the total number of rented properties in the database
    * @return : returns an int of all rented
    */
    public int getTotalRented(){
        int totalRented = 0;
        try{
            String query = "SELECT * FROM property WHERE status = 'Rented'";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                totalRented++;
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalRented;
    }

    /**
    * Retrieves the total number of active properties in the database
    * @return : returns an int of all active
    */
    public int getTotalActive(){
        int totalActive = 0;
        try{
            String query = "SELECT * FROM property WHERE status = 'Active'";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                totalActive++;
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalActive;
    }

    /**
    * Retrieves all the properties that are currently rented in the database
    * @return : returns an Arraylist of all the rented houses
    */
    public ArrayList<Property> getHousesRented(){
        ArrayList<Property> housesRented = new ArrayList<Property>();
        try{
            String query = "SELECT * FROM property WHERE status = 'Rented'";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                housesRented.add(new Property(results.getInt("ID"), results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")), Date.valueOf(results.getString("paymentExpiry")), results.getString("status") ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return housesRented;
    }


}
