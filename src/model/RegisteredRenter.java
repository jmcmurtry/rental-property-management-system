package model;

/* 
 /* 
 * RegisteredRenter.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

import java.util.ArrayList;

public class RegisteredRenter extends UserProfile implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Property> filteredProperties;
    private ArrayList<Property> propertiesRented;

    
	/**
	 * Constructor of RegisteredRenter that calls the UserProfile constructor 
	 * to inherit all the User's methods like getID, getEmail, setEmail, set and get password etc
	 */
    
    public RegisteredRenter(String name, String email, String pswd){
        super(name, email, pswd);
    }
    
    
    /**
     * Method to register the renter for further notifications and add them to an arraylist of observers
     * @param o
     */
    public void register(Observer o){
        observers.add(o);
        o.update(filteredProperties);
    }

    /**
     * Method to unregister a renter and remove them from the observers list
     * @param o
     */
    public void remove(Observer o){
        observers.remove(o);
    }
    
    /**
     * Method to notify all the observers in the observers ArrayList
     */
    public void notifyObserver(){
        for(int i = 0; i < observers.size(); i++){
            Observer o = observers.get(i);
            o.update(filteredProperties);
        }
    }

    public void unsubscribe(){
    }
    
    /**
     * Method to add a property to the propertiesRented ArrayList
     * @param p
     */
    public void addProperty(Property p){
        propertiesRented.add(p);
    }

}

