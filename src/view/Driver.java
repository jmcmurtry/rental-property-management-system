package view;
import model.*;
import controller.*;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

/* 
 * Driver.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class Driver {

    // static AppController theController = AppController.getInstance();
    private static double fee = 30;
    private static int numberOfDays = 60;

    // static functions for the login page

    public static void registerButtonPressed(){
        new RegistrationGUI();
    }

    public static Boolean authenticateLogin(String userLoginType, String email, String password){
        // needs to communicate with controller then return true if login is valid otherwise return false
        // needs to check database to confirm that the user exists and that the password is correct
        //UserController uc = new UserController();
        //return uc.validateUser(userLoginType, email, password); // return value from controller function
        return true;
    }

    public static void renterLoginButtonPressed(){
        new RenterGUI();
    }

    public static void landlordLoginButtonPressed(String landlordEmail){
        //int landlordID = function that needs to connect with controller/database and return landlord id when given landlord email
        // UserController uc = new UserController();
        // int landlordID = uc.getLandlordID(landlordEmail);
        new LandlordGUI(1);
    }   
    
    public static void managerLoginButtonPressed(){
        // new ManagerGUI();
    }    

    public static void guestButtonPressed(){
        new SearchGUI();
    }

    // static functions for the register page

    public static void newRegistrationSubmitted(UserProfile newUser, String userType){
        // takes in a UserProfile object as well as a string to identify the user type
        // String can be "Renter" or "Landlord"
        // connect with database controllers here
        UserController uc = new UserController();
        // int userID = uc.createUser(newUser, userType);
        uc.createUser(newUser, userType);
        new LoginGUI();
    }

    // static functions for landlord page

    public static void submitPropertyRegistrationPressed(Property newProperty){
        // takes in a property object that will be used to comunicate with database
        // need to implement communication with database
        // listing status will be set to inactive
        PropertyController pc = new PropertyController();
        pc.createProperty(newProperty);
    }

    public static void submitPropertyRenewalPaymentPressed(int propertyID){
        // passes in property id - database updates status to listed
       // need to implement communication with database 
       // will take in a property object and payment object
       // need to store the payment information and set the listing status to active
    }

    // public static ArrayList<Property> managePropertiesButtonPressed(int landlordID){
    //     // returns an array list of property objects that the landlord owns
    // }

    public static String getPaymentFee(){
        return String.valueOf(fee);
    }

    public static String getNumberOfFeeDays(){
        return String.valueOf(numberOfDays);
    }

    // static functions for search page

    public static void getSearchResults(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        // need to call a function that uses the above parameters
        // function should search through database for properties that match the search query
        // function should then return an ArrayList of type property called PropertyList containing all properties that match search criteria
        SearchController sc = new SearchController();
        // sc.performSearch(propertyType, noBeds, noBaths, furnished, quadrant);
        ArrayList<Property> PropertyList = sc.performSearch(propertyType, noBeds, noBaths, furnished, quadrant);
        new SearchResultsGUI(PropertyList);
    }

    // static functions for manager page

    public static void setPaymentFee(double newFee){
        fee = newFee;
    }

    public static void setNumberOfFeeDays(int days){
        numberOfDays = days;
    }
}
