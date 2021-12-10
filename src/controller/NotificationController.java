package controller;


import java.sql.*;


//import model.Property;

public class NotificationController extends AppController {

    public NotificationController(){
        super();
    }
    
    public void insertSearchCriteria(int renter_id, String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
       
        String query = "INSERT INTO subscribed_renters(subrenter_id,type,noOfBedrooms,noOfBathrooms,furnishing,cityQuadrant) VALUES "+renter_id;
        try{
            if(propertyType != "No preference"){
                query = query + ", "+propertyType;        
            }else if (propertyType == "No preference") {
            	query = query + ", "+null; 
            }
            if(noBeds != "No preference"){
            	query = query + ", "+noBeds;  
            	}else if (noBeds == "No preference") {
                	query = query + ", "+null; 
                }
            if(noBaths != "No preference"){
            	query = query + ", "+noBaths;  
            }else if (noBaths == "No preference") {
            	query = query + ", "+null; 
            }
            if(furnished != "No preference"){
            	if(furnished=="No") {
            	query = query + ", "+0;
            	}else if(furnished=="Yes")
            	query = query + ", "+1;
            }else if (furnished == "No preference") {
            	query = query + ", "+null; 
            }
            if(quadrant != "No preference"){   
            	query = query + ", "+quadrant;
            }else if (quadrant == "No preference") {
            	query = query + ", "+null; 
            }    
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.executeUpdate();
            myStmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
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
