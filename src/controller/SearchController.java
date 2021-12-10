package controller;

import java.util.ArrayList;
import model.*;
import java.sql.*;

public class SearchController extends AppController{
   
    /**
    * Constructor - allows access to database
    */
    public SearchController(){
        super();
    }

    /**
    * Retrieves all the properties that match the provided search criteria
    * @param propertyType : the propery type wanted
    * @param noBeds : the number of bedrooms type wanted
    * @param noBaths : the number of bathrooms type wanted
    * @param furnished : whether the property is furnished or not
    * @param quadrant : the quadrant of the property wanted
    * @return : returns an ArrayList containing all the properties that match
    */
    public ArrayList<Property> performSearch(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        ArrayList<Property> found = new ArrayList<Property>();
        String query = "SELECT * FROM property WHERE status = 'Active'";
        try{
            if(propertyType != "No preference"){
                query = query + " and type = '" + propertyType + "'";
            }
            if(noBeds != "No preference"){
                query = query + " and noOfBedrooms = " + noBeds;
            }
            if(noBaths != "No preference"){
                query = query + " and noOfBathrooms = " + noBaths;
            }
            if(furnished != "No preference"){
                if(furnished == "No"){
                    query = query + " and furnishing = 0";
                }else if(furnished == "Yes"){
                    query = query + " and furnishing = 1";
                }
            }
            if(quadrant != "No preference"){
                query = query + " and cityQuadrant = '" + quadrant + "'";
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
