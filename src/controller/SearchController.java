package controller;

import java.util.ArrayList;
import model.*;
import java.sql.*;

public class SearchController extends AppController{
    public SearchController(){
        super();
    }

    public ArrayList<Property> performSearch(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        ArrayList<Property> found = new ArrayList<Property>();
        String query = "SELECT * FROM property WHERE status = 'Active'";
        try{
            if(propertyType != "No preference"){
                query = query + " and type = '" + propertyType + "' and 1=1";
            }
            if(noBeds != "No preference"){
                query = query + " and noOfBedrooms = " + noBeds + " and 1=1";
            }
            if(noBaths != "No preference"){
                query = query + " and noOfBathrooms = " + noBaths + " and 1=1";
            }
            if(furnished != "No preference"){
                query = query + " and furnishing = " + furnished + " and 1=1";
            }
            if(quadrant != "No preference"){
                query = query + " and cityQuadrant = '" + quadrant + "' and 1=1";
            }
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                found.add(new Property(results.getInt("ID"), results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")), Date.valueOf(results.getString("paymentExpiry")), results.getString("status") ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return found;
    }
}
