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

    /**
    * Constructor - allows access to database
    */
    public EmailController(){
        super();
    }

    /**
    * Adds an email to the email table associated to a landlord
    * @param renterEmail : the email of the renter seeking to contact a landlord
    * @param propertyID : the propery id of the property renter is interested in
    * @param message : String containing the message to send to the landlord
    */
    public void sendEmail(String renterEmail, int propertyID, String message) {
        try {
            int landlordID = getLandlordIDFromProperty(propertyID);
            String query = "INSERT INTO email(landlordID, renterEmail, propertyID, message) VALUES(?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, landlordID);
            myStmt.setString(2, renterEmail);
            myStmt.setInt(3, propertyID);
            myStmt.setString(4, message);
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * retrieves all the emails send to a specific landlord
    * @param landlordID : the id of the landlord whose emails wanted to get
    * @return : returns an ArrayList containing all the emails for a specific landlord
    */
    public ArrayList<Email> retrieveEmails(int landlordID) {
        ArrayList<Email> emails = new ArrayList<Email>();
        try {
            String query = "SELECT * FROM EMAIL WHERE landlordID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setInt(1, landlordID);
            ResultSet results = myStmt.executeQuery();
            while(results.next()){
                emails.add(new Email(results.getInt("email_id"), landlordID, results.getString("renterEmail"), results.getInt("propertyID"), results.getString("message") ));
            }
            myStmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return emails;
    }


    /**
    * retrieves the id of the landlord who owns the specified property
    * @param PropertyID : the id of the specified property
    * @return : returns an int representing the id of the landlord
    */
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


    /**
    * deletes an email given its id
    * @param emailID : the id of the specified email to delete
    * @return : returns a boolean indicating success
    */
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
