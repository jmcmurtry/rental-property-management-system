package controller;
import java.sql.*;

/* 
 * AppController.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class AppController{

    // database URL
    private final String DBURL;
    
    // database USERNAME
    private final String USERNAME;

    // database PASSWORD
    private final String PASSWORD;
    
    // Connection object
    public Connection dbConnecter;

    // Server class's ResultSet object
    public ResultSet results;

    private static AppController appInstance = null;
     
    private AppController(){}

    public static AppController getInstance(){
        if(appInstance == null){
            appInstance = new AppController();
        }
        return appInstance;
    }

    public void connectDatabase(){
        try{
            this.dbConnecter = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}