package controller;

import java.sql.*;

import model.*;

public class UserController extends AppController{
    public UserController(){
        super();
    }

    public boolean validateUser(String userType, String email, String password){
        try{
            String query = "SELECT ? FROM ? WHERE email = ? and password = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, userType + "_id");
            myStmt.setString(2, userType);
            myStmt.setString(3, email);
            myStmt.setString(4, password);
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
            String query = "INSERT INTO ? (Name, Email, Password) VALUES(?, ?, ?)";
            // String query = "INSERT INTO ? (Name, Email, Password) VALUES(?, ?, ?) SELECT LAST_INSERT_ID()";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, userType);
            myStmt.setString(2, newUser.getName());
            myStmt.setString(3, newUser.getEmail());
            myStmt.setString(4, newUser.getPassword());
            // myStmt.executeUpdate();
            myStmt.execute();
            // ResultSet results = myStmt.executeQuery();
            // ResultSet results = myStmt.getGeneratedKeys();
            myStmt.close();
            // return results.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        // return 0; // if failed to create user
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

}
