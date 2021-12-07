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

    public static Boolean authenticateLogin(String userLoginType, String username, String password){
        // needs to communicated with AppController then return true if login is valid otherwise return false
        // needs to check database to confirm that the user exists and that the password is correct
        return true; // change later
    }

    public static void renterLoginButtonPressed(){
        new RenterGUI();
    }

    public static void landlordLoginButtonPressed(){
        new LandlordGUI();
    }   
    
    public static void managerLoginButtonPressed(){
        // new ManagerGUI();
    }    

    public static void guestButtonPressed(){
        new SearchGUI();
    }

    // static functions for the register page

    public static void newRegistrationSubmitted(){
        // will take in a user object and will need to be passed to the database for storage
        new LoginGUI();
    }

    // static functions for landlord page

    public static void submitPropertyRegistrationPressed(){
        // need to implement communication with database
        // will take in a property object and will need to be passed to the database for storage
        // listing status will be set to inactive
    }

    public static void submitPropertyPaymentPressed(){
       // need to implement communication with database 
       // will take in a property object and payment object
       // need to store the payment information and set the listing status to active
    }
}
