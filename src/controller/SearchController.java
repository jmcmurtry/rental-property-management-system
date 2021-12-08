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
        try{
            String query = "SELECT * FROM property WHERE type = ? and noOfBedrooms = ? and noOfBathrooms = ? and furnishing = ? and cityQuadrant = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, propertyType);
            myStmt.setString(2, noBeds);
            myStmt.setString(3, noBaths);
            myStmt.setString(4, furnished);
            myStmt.setString(5, quadrant);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                found.add(new Property(results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")) ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return found;
    }
}
