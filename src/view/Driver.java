package view;

import model.*;
import controller.*;
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
        UserController uc = new UserController();
        return uc.validateUser(userLoginType, email, password); // return value from controller function
    }

    public static void renterLoginButtonPressed(){
        new RenterGUI();
    }

    public static void landlordLoginButtonPressed(String landlordEmail){
        //int landlordID = function that needs to connect with controller/database and return landlord id when given landlord email
        UserController uc = new UserController();
        int landlordID = uc.getLandlordID(landlordEmail);
        new LandlordGUI(landlordID);
    }   
    
    public static void managerLoginButtonPressed(){
        new ManagerGUI();
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
        PropertyController pc = new PropertyController();
        pc.changeStatus(propertyID, "Active");
        java.time.LocalDate today =  java.time.LocalDate.now().plusDays(60);
        java.sql.Date date = java.sql.Date.valueOf(today.toString());
        pc.changePaymentExpiry(propertyID, date);
    }

    public static void managePropertiesButtonPressed(int landlordID){
        // grabs array list of properties from database based on landlord id
        UserController uc = new UserController();
        ArrayList<Property> properties = uc.getLandlordProperties(landlordID);
        new LandlordPropertiesGUI(properties, landlordID);
    }

    public static void backToLandlordMenu(int landlordID){
        new LandlordGUI(landlordID);
    }

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
        ArrayList<Property> PropertyList = sc.performSearch(propertyType, noBeds, noBaths, furnished, quadrant);
        new SearchResultsGUI(PropertyList);
    }

    // static functions for manager page

    public static void setFeeInfo(double newFee, int days){
        fee = newFee;
        numberOfDays = days;
        PaymentController pc = new PaymentController();
        pc.setFeeInfo(newFee, days);
    }
    
    public static void changeListingState(int propertyID, String newState){
        // needs to change the property with id "propertyID" to the newState in the database
    }


    // manager functions
    public static int totalHousesListedManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalListed();
    }

    public static int totalRentedManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalRented();
    }

    public static int totalActiveManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalActive();
    }

    //need list of houses

}
