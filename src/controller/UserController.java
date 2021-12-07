package controller;

import java.sql.*;
import model.*;

public class UserController extends AppController{
    public UserController(){
        super();
    }

    public boolean validateUser(String userType, String email, String password){
        try{
            String query = "SELECT ? FROM ? WHERE email=? and password = ?";
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

    public boolean createUser(String userType, String name, String email, String password){
        // RegisteredRenter reg = new RegisteredRenter(name, email, password);
        try{
            // String query = "INSERT INTO ? (?_id, Name, Email, Password) VALUES(?, ?, ?, ?)";
            // PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            // myStmt.setString(1, userType);
            // myStmt.setString(2, userType);
            // myStmt.setString(3, idGenerate);
            // myStmt.setString(4, name);
            // myStmt.setString(5, email);
            // myStmt.setString(6, password);
            // myStmt.executeUpdate();
            // myStmt.close();
            String query = "INSERT INTO ? (Name, Email, Password) VALUES(?, ?, ?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, userType);
            myStmt.setString(2, name);
            myStmt.setString(3, email);
            myStmt.setString(4, password);
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(userType == "renter"){
            RegisteredRenter r = new RegisteredRenter(name, email, password);
            renters.add(r);

        }else if(userType == "landlord"){
            Landlord l = new Landlord(name, email, password);
            landlords.add(l);
        }
        return true;
    }

    public boolean removeRenter(int userID){
        try{
            // just delete renters - if delete a landlord need to remove property
            String query = "DELETE FROM renter WHERE ID = ?";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setString(1, Integer.toString(userID));
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        for(RegisteredRenter r : renters){
            if(r.getID()== userID){
                renters.remove(r);
            }
        }
    
        return true;
    }
    // public boolean removeUser(String userType, int userID){
    //     try{
    //         // just delete renters - if delete a landlord need to remove property
    //         String query = "DELETE FROM " + userType + " WHERE ID = ?";
    //         PreparedStatement myStmt = dbConnecter.prepareStatement(query);
    //         myStmt.setString(1, Integer.toString(userID));
    //         myStmt.executeUpdate();
    //         myStmt.close();
    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }
    //     if(userType == "renter"){
    //         for(RegisteredRenter r : renters){
    //             if(r.getID()== userID){
    //                 renters.remove(r);
    //             }
    //         }
    //     }else if(userType == "landlord"){
    //         for(Landlord l : landlords){
    //             if(l.getID()== userID){
    //                 landlords.remove(l);
    //             }
    //         }
    //     }
    //     return true;
    // }

}
