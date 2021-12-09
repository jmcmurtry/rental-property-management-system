package controller;
import java.sql.*;
import model.*;

public class PropertyController extends AppController{
    
	public PropertyController() {
		super();
	}

	public void createProperty(Property property) {
		try {
            String query = "INSERT INTO property(address, type, paymentExpiry, status, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant, price, landLordID) "
					+ " VALUES (?,?,?,'Active',?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1,property.getAddress());
            myStmt.setString(2, property.getType());
            myStmt.setDate(3, property.getPaymentExpiry());
            myStmt.setInt(4,property.getBed());
            myStmt.setInt(5, property.getBath());
            myStmt.setBoolean(6, property.getFurnished());
            myStmt.setString(7,property.getQuadrant());
            myStmt.setInt(8,property.getRentPrice());
            myStmt.setInt(9, property.getLandlord());

            myStmt.executeUpdate();
            myStmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

    public void changeStatus(int propertyID, String newStatus){   
        try{
            String query =  "UPDATE property SET status = ? WHERE ID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, newStatus);
            myStmt.setString(2, Integer.toString(propertyID));
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
    }

    public void changePaymentExpiry(int propertyID, java.sql.Date newExpiry){   
        try{
            String query =  "UPDATE property SET paymentExpiry = ? WHERE ID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setDate(1, newExpiry);
            myStmt.setString(2, Integer.toString(propertyID));
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
    }
	
    public boolean removeProperty(int propertyID){
        try{
            String query = "DELETE FROM property WHERE ID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, Integer.toString(propertyID));
            myStmt.executeUpdate();
            myStmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


	
	
}
