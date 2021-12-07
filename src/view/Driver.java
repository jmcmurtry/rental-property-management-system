package view;
import model.*;
import controller.AppController;

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

    // static functions for the login page

    public static void registerButtonPressed(){
        new RegistrationGUI();
    }

    public static Boolean authenticateLogin(String userLoginType, String email, String password){
        // needs to communicate with controller then return true if login is valid otherwise return false
        // needs to check database to confirm that the user exists and that the password is correct
        return true; // return value from controller function
    }

    public static void renterLoginButtonPressed(){
        new RenterGUI();
    }

    public static void landlordLoginButtonPressed(String landlordEmail){
        //int landlordID = function that needs to connect with controller/database and return landlord id when given landlord email
        new LandlordGUI(landlordID);
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
        new LoginGUI();
    }

    // static functions for landlord page

    public static void submitPropertyRegistrationPressed(Property newProperty){
        // takes in a property object that will be used to comunicate with database
        // need to implement communication with database
        // listing status will be set to inactive
    }

    public static void submitPropertyPaymentPressed(){
       // need to implement communication with database 
       // will take in a property object and payment object
       // need to store the payment information and set the listing status to active
    }

    // static functions for search page

    public static void getSearchResults(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        // need to call a function that uses the above parameters
        // function should search through database for properties that match the search query
        // function should then return an ArrayList of type property called PropertyList containing all properties that match search criteria
        // ArrayList<Property> PropertyList = return value of the function
        new SearchResultsGUI(PropertyList);
    }
}
