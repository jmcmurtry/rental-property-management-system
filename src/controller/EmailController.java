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
import java.util.ArrayList;
import model.Email;
public class EmailController extends AppController {

    public EmailController(){
        super();
    }

    public void sendEmail(int RenterID, int PropertyID, String message) {
        try {
            int landlordID = getLandlordIDFromProperty(PropertyID);
            String query = "INSERT INTO email(landlordID, renterID, propertyID, message) VALUES(?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, landlordID);
            myStmt.setInt(2, RenterID);
            myStmt.setInt(3, PropertyID);
            myStmt.setString(4, message);
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Email> retrieveEmails(int landlordID) {
        ArrayList<Email> emails = new ArrayList<Email>();
        UserController us = new UserController();
        try {
            String query = "SELECT * FROM EMAIL WHERE landlordID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, landlordID);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                emails.add(new Email(results.getInt("email_id"), landlordID, us.getRenterName(results.getInt("renterID")), results.getInt("propertyID"), results.getString("message") ));
            }
            myStmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return emails;
    }


    public int getLandlordIDFromProperty(int PropertyID){
        try{
            String query = "SELECT landlordID FROM property WHERE ID = ? ";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, PropertyID);
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                return results.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public boolean deleteEmail(int emailID){
        try{
            String query = "DELETE FROM email WHERE email_id = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, emailID);
            myStmt.executeUpdate();
            myStmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
