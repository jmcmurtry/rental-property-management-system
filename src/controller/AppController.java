package controller;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/* 
 * AppController.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class AppController{

    // database URL
    private final String DBURL = "jdbc:mysql://localhost/PROPERTY_MANAGEMENT";
    
    // database USERNAME
    private final String USERNAME = "group17";

    // database PASSWORD
    private final String PASSWORD = "ensf480";
    
    // Connection object
    public Connection dbConnecter;

    private static AppController appInstance = null;
     
    public static AppController getInstance(){
        if(appInstance == null){
            appInstance = new AppController();
        }
        return appInstance;
    }

    /**
    * Constructor - initialize connection to the database
    */
    public AppController(){
        try{
            this.dbConnecter = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
