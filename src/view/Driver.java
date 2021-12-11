package view;

import model.*;
import controller.*;

import java.util.ArrayDeque;
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

    /**
    * Creates a new registration page upon a button press
    */
    public static void registerButtonPressed(){
        new RegistrationGUI();
    }

    /**
    * Checks the database to authenticate a user login
    * @param userloginType : String that represents the type of user
    * @param email : user email
    * @param password : user password
    * @return : returns the truth value of if the login was valid
    */
    public static Boolean authenticateLogin(String userLoginType, String email, String password){
        // needs to communicate with controller then return true if login is valid otherwise return false
        // needs to check database to confirm that the user exists and that the password is correct
        UserController uc = new UserController();
        return uc.validateUser(userLoginType, email, password); // return value from controller function
    }

    /**
    * Creates a new renter page upon button press
    * @param email : String that represents renter email
    */
    public static void renterLoginButtonPressed(String email){
        new RenterGUI(email);
    }

    /**
    * Creates a new lanndlord page upon button press
    * @param landlordEmail : String that represents renter email
    */
    public static void landlordLoginButtonPressed(String landlordEmail){
        //int landlordID = function that needs to connect with controller/database and return landlord id when given landlord email
        UserController uc = new UserController();
        int landlordID = uc.getLandlordID(landlordEmail);
        new LandlordGUI(landlordID);
    }   
    
    /**
    * Displays a new manager page upon a button press action
    */    
    public static void managerLoginButtonPressed(){
        new ManagerGUI();
    }    

    /**
    * Creates a new search page upon button press
    */
    public static void guestButtonPressed(){
        new SearchGUI();
    }

    /**
    * Creates a new user in the database upon registration
    * @param newUser : UserProfile object that is used to construct a new user
    * @param userType : represents the type of user
    */
    public static void newRegistrationSubmitted(UserProfile newUser, String userType){
        // takes in a UserProfile object as well as a string to identify the user type
        // String can be "Renter" or "Landlord"
        // connect with database controllers here
        UserController uc = new UserController();
        uc.createUser(newUser, userType);
        new LoginGUI();
    }

    /**
    * registers a new property in the database
    * @param newProperty : property to be added
    */
    public static void submitPropertyRegistrationPressed(Property newProperty){
        // takes in a property object that will be used to comunicate with database
        // need to implement communication with database
        // listing status will be set to inactive
        PropertyController pc = new PropertyController();
        pc.createProperty(newProperty);
    }

    /**
    * Renews the property in the database - status will change to active
    * @param propertyID : integer that represents the property to be renewed
    */
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

    /**
    * Creates a new landlord properties page upon button press
    * @param landlordID : int that represents landlord ID
    */
    public static void managePropertiesButtonPressed(int landlordID){
        // grabs array list of properties from database based on landlord id
        UserController uc = new UserController();
        ArrayList<Property> properties = uc.getLandlordProperties(landlordID);
        new LandlordPropertiesGUI(properties, landlordID);
    }

    /**
    * Goes back to the landlord menu
    * @param landlordID : int that represents landlord ID
    */
    public static void backToLandlordMenu(int landlordID){
        new LandlordGUI(landlordID);
    }

    /**
    * Gets the new payment amount
    * @return : returns a String that represents the new payment fee amount
    */
    public static String getPaymentFee(){
        PaymentController pc = new PaymentController();
        return pc.getPaymentFee();
    }

    /**
    * Gets the new payment number of days
    * @return : returns a String that represents the number of days
    */
    public static String getNumberOfFeeDays(){
        PaymentController pc = new PaymentController();
        return pc.getNumberOfFeeDays();
    }

    /**
    * Retrieves all landlord emails to display on the landlord GUI
    * @param landlordID : int to represent the landlord whose emails are to be retrieved
    * @return : returns an ArrayList of type Email that has all landlord emails
    */    
    public static ArrayList<Email> retrieveAllEmails(int landlordID){
        EmailController ec = new EmailController();
        return ec.retrieveEmails(landlordID);
    }
    
    /**
    * Creates a new search results page
    * @param propertyType : String that represents type of property 
    * @param noBeds : String that represents number of beds
    * @param noBaths : String that represents number of bathrooms 
    * @param furnished : String that represents if the property is furnished
    * @param quadrant : String that represents quadrant the property is located in
    */
    public static void getSearchResults(String propertyType, String noBeds, String noBaths, String furnished, String quadrant){
        // need to call a function that uses the above parameters
        // function should search through database for properties that match the search query
        // function should then return an ArrayList of type property called PropertyList containing all properties that match search criteria
        SearchController sc = new SearchController();
        ArrayList<Property> PropertyList = sc.performSearch(propertyType, noBeds, noBaths, furnished, quadrant);
        new SearchResultsGUI(PropertyList);
    }

    /**
    * Gets the search results based on an input search criteria. Will open a new registered search results page to display the output
    * @param propertyType : String that represents type of property 
    * @param noBeds : String that represents number of beds
    * @param noBaths : String that represents number of bathrooms 
    * @param furnished : String that represents if the property is furnished
    * @param quadrant : String that represents quadrant the property is located in
    * @param email : String that represents the renter email
    */
    public static void getRegisteredSearchResults(String propertyType, String noBeds, String noBaths, String furnished, String quadrant, String email){
        // need to call a function that uses the above parameters
        // function should search through database for properties that match the search query
        // function should then return an ArrayList of type property called PropertyList containing all properties that match search criteria
        SearchController sc = new SearchController();
        ArrayList<Property> PropertyList = sc.performSearch(propertyType, noBeds, noBaths, furnished, quadrant);
        Search s = new Search(propertyType, noBeds, noBaths, furnished, quadrant);
        new RegisteredSearchResultsGUI(PropertyList, email, s);
    }    

    /**
    * Goes back to the registered renter menu page
    * @param email : String that represents the renter's email 
    */
    public static void backToRegisteredRenterMenu(String email){
        new RenterGUI(email);
    }
   
    /**
    * returns to the unregistered renter menu upon a button press
    */
    public static void backToUnregisteredRenterMenu(){
        new SearchGUI();
    }

    /**
    * Sends email to landlord
    * @param renterEmail : String that represents email of renter 
    * @param propertyID : int that representes the id of interested property
    * @param message : String that represents message to be sent 
    */
    public static void sendEmailToLandlord(String renterEmail, int propertyID, String message){
        EmailController ec = new EmailController();
        ec.sendEmail(renterEmail, propertyID, message);
    }

    /**
    * Changes the payment information in the database.
    * @param newFee : double that represents the new fee amount
    * @param days : int that represents the new number of days the payment is valid for
    */
    public static void setFeeInfo(double newFee, int days){
        PaymentController pc = new PaymentController();
        pc.setFeeInfo(newFee, days);
    }
    
    /**
    * Changes the listing state of a property
    * @param propertyID : int that represents ID of property 
    * @param newState : String that represents the state to change to
    */
    public static void changeListingState(int propertyID, String newState){
        PropertyController pc = new PropertyController();
        pc.changeStatus(propertyID, newState);
    }

    /**
    * function that is used to get the total number of houses listed in the period
    * @return : returns the total number of houses listed
    */
    public static int totalHousesListedManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalListed();
    }

    /**
    * function that is used to get the total number of houses rented in the period
    * @return : returns the total number of houses rented
    */
    public static int totalRentedManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalRented();
    }

    /**
    * function that is used to get the total number of active houses in the period
    * @return : returns the total number of active houses
    */
    public static int totalActiveManager(){
        SummaryReportController src = new SummaryReportController();
        return src.getTotalActive();
    }

    /**
    * function that is used to get the list of rented properties in the period
    * @return : returns an ArrayList of Properties that are rented
    */
    public static ArrayList<Property> listRented(){
        SummaryReportController src = new SummaryReportController();
        return src.getHousesRented();
    }

    /**
    * function that is used to get the landlord name based on their ID
    * @param landlordID : represents the landlord ID 
    * @return : returns the landlord name
    */
    public static String getLandlordName(int landlordID){
        UserController uc = new UserController();
        return uc.getLandlordName(landlordID);
    }

    /**
    * function that is used to get all of the registered renters in the database
    * @return : returns an ArrayList of type RegisteredRenter containing all renters
    */
    public static ArrayList<RegisteredRenter> getAllRentersManager(){
        UserController uc = new UserController();
        return uc.getAllRenters();
    }
    
    /**
    * function that is used to get all landlords in the database
    * @return : returns an ArrayList of all landlords in the database
    */
    public static ArrayList<Landlord> getAllLandlordsManager(){
        UserController uc = new UserController();
        return uc.getAllLandlords();
    }

    /**
    * function that is used to get all of the properties in the database
    * @return : returns an ArrayList of type Property containing all properties
    */    
    public static ArrayList<Property> getAllPropertiesManager(){
        PropertyController pc = new PropertyController();
        return pc.getAllProperties();
    }

    /**
    * Inserts search criteria into the database based on a user subscription
    * @param search : represents the search criteria
    * @param email : represents the renters email
    */
    public static void addSubSearch(Search search, String email){
        NotificationController nc = new NotificationController();
        nc.insertSearchCriteria(email, search.getType(), search.getBed(), search.getBath(), search.getFurnished(), search.getQuadrant());
    }

    /**
    * function used to manage the subscribed renters notifications and return 
    * properties posted according to their criteria
    * @param email : String email of the subscribed renter
    * @return : returns an ArrayList of properties found matching the renter's search criteria
    */
    public static ArrayList<Property> performSubSearch(String email){
        NotificationController nc = new NotificationController();
        ArrayList<Property> found = nc.getSubscriptionSearch(email);
        return found;
    }
}
