package controller;
/* 
 * Landlord.java
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

public class UserController extends AppController{
    public UserController(){
        super();
    }

    public boolean validateUser(String userType, String email, String password){
        try{
            String query = "SELECT " + userType + "_id" + " FROM " + userType + " WHERE email = ? and password = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, email);
            myStmt.setString(2, password);
            ResultSet results = myStmt.executeQuery();
            if(!results.next()){
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public void createUser(UserProfile newUser, String userType){ // either renter or landlord
        try{
            String query = "INSERT INTO " + userType + "(name, email, password) VALUES(?, ?, ?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, newUser.getName());
            myStmt.setString(2, newUser.getEmail());
            myStmt.setString(3, newUser.getPassword());
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public boolean removeRenter(int userID){
        try{
            String query = "DELETE FROM renter WHERE renter_id = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, Integer.toString(userID));
            myStmt.executeUpdate();
            myStmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int getLandlordID(String email){
        try{
            String query = "SELECT landlord_id FROM landlord WHERE email = ? ";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, email);
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                return results.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Property> getLandlordProperties(int userID){
        ArrayList<Property> properties = new ArrayList<Property>();
        try{
            String query = "SELECT * FROM property WHERE landlordID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, Integer.toString(userID));
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                properties.add(new Property(results.getInt("ID"), results.getString("address"), results.getString("type"), Integer.parseInt(results.getString("noOfBedrooms")), Integer.parseInt(results.getString("noOfBathrooms")), 
                Boolean.parseBoolean(results.getString("furnishing")), results.getString("cityQuadrant"), Integer.parseInt(results.getString("landlordID")), Integer.parseInt(results.getString("price")), Date.valueOf(results.getString("paymentExpiry")), results.getString("status") ));
            }
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    public String getLandlordName(int LandlordID){
        try{
            String query = "SELECT name FROM landlord WHERE landlord_id = ? ";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, LandlordID);
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                return results.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    

    public ArrayList<Landlord> getAllLandlords(){
        ArrayList<Landlord> landlords = new ArrayList<Landlord>();
        try{
            String query = "SELECT * FROM landlord";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                landlords.add(new Landlord(results.getString("name") , results.getString("email"), results.getString("password") ));
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return landlords;
    }

    public ArrayList<RegisteredRenter> getAllRenters(){
        ArrayList<RegisteredRenter> renters = new ArrayList<RegisteredRenter>();
        try{
            String query = "SELECT * FROM renter";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                renters.add(new RegisteredRenter(results.getString("name") , results.getString("email"), results.getString("password") ));
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return renters;
    }
}
