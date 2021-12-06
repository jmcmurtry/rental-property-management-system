public class Driver {

    // static AppController theController = AppController.getInstance();

    // static functions for the login page

    public static void registerButtonPressed(){
        new RegistrationGUI();
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
}
