package controller;
import java.sql.*;
import model.*;


public class PropertyController extends AppController{
    
	public PropertyController() {
		super();
	}
	
	public void createProperty(Property property) {
		try {
			String query = "INSERT INTO property(address, type, dateListed, paymentExpiry, noOfBedrooms, noOfBathrooms, furnishing, cityQuadrant, price, landLordID) "
					+ "      VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1,property.getAddress());
            myStmt.setString(2, property.getType());
            myStmt.setDate(3, property.getDateListed());
            Date expiry = Date.valueOf(property.getDateListed().toLocalDate().plusDays(60));
            myStmt.setDate(4,expiry);
            myStmt.setInt(5,property.getBed());
            myStmt.setInt(6, property.getBath());
            myStmt.setBoolean(7, property.getFurnished());
            myStmt.setString(8,property.getQuadrant());
            myStmt.setInt(9,property.getRentPrice());
            myStmt.setInt(10, property.getLandlord());

            myStmt.execute();
            myStmt.close();
		}
		catch(Exception e){
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
