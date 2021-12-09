package controller;

import java.sql.*;
import model.*;
import java.util.ArrayList;
public class SummaryReportController extends AppController{
    public SummaryReportController(){
        super();
    }

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
        System.out.println("total Listed: " + totalListed);
        return totalListed;
    }


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
        System.out.println("total Rented: " + totalRented);
        return totalRented;
    }

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
        System.out.println("total Active: " + totalActive);
        return totalActive;
    }

    public ArrayList<Property> getHousesRented(){
        ArrayList<Property> housesRented = new ArrayList<Property>();
        try{
            String query = "SELECT * FROM property WHERE status = 'Rented'";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                housesRented.add(new Property(results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")), Date.valueOf(results.getString("paymentExpiry")), results.getString("status") ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return housesRented;
    }


}
