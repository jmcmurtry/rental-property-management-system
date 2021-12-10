package controller;
/* 
 * NotificationController.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

import java.sql.*;
import java.util.ArrayList;
import model.Property;

public class NotificationController extends AppController {

    public NotificationController(){
        super();
    }
    
    public void insertSearchCriteria(int renter_email, String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        String query = "INSERT INTO subscribed_renters(subrenter_email, type, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant) VALUES " + renter_email;
        try{
            if(propertyType != "No preference"){
                query = query + ", " + propertyType;        
            }else if (propertyType == "No preference") {
            	query = query + ", " + null; 
            }
            if(noBeds != "No preference"){
            	query = query + ", " + noBeds;  
            	}else if (noBeds == "No preference") {
                	query = query + ", " + null; 
                }
            if(noBaths != "No preference"){
            	query = query + ", " + noBaths;  
            }else if (noBaths == "No preference") {
            	query = query + ", " + null; 
            }
            if(furnished != "No preference"){
            	if(furnished == "No") {
            	query = query + ", " + 0;
            	}else if(furnished == "Yes")
            	query = query + ", " + 1;
            }else if (furnished == "No preference") {
            	query = query + ", " + null; 
            }
            if(quadrant != "No preference"){   
            	query = query + ", " + quadrant;
            }else if (quadrant == "No preference") {
            	query = query + ", " + null; 
            }    
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.executeUpdate();
            myStmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
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
    public ArrayList<Property> performSubscriptionSearch(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        ArrayList<Property> subResults = new ArrayList<Property>();
        String query = "SELECT * FROM property WHERE status = 'Active'";
        try{
            if(propertyType != null){
                query = query + " and type = '" + propertyType + "'";
            }
            if(noBeds != null){
                query = query + " and noOfBedrooms = " + noBeds;
            }
            if(noBaths != null){
                query = query + " and noOfBathrooms = " + noBaths;
            }
            if(furnished != null){
                if(furnished == "No"){
                    query = query + " and furnishing = 0";
                }else if(furnished == "Yes"){
                    query = query + " and furnishing = 1";
                }
            }
            if(quadrant != null){
                query = query + " and cityQuadrant = '" + quadrant + "'";
            }
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                subResults.add(new Property(results.getInt("ID"), results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")), Date.valueOf(results.getString("paymentExpiry")), results.getString("status") ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return subResults;
    }

    public void removeSubscription(int renter_id) {
        try{
            String query = "DELETE FROM subscribed_renters WHERE subrenter_id = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, Integer.toString(renter_id));
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();   	
        }
    }
    
}
