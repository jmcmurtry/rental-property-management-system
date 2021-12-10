package model;

/* 
 * Landlord.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

import java.util.ArrayList;

public class Landlord extends UserProfile{
    ArrayList<Property> properties;

    
	/**
	 * Constructor of Landlord that calls the UserProfile constructor 
	 * to inherit all the User's methods like getID, getEmail, setEmail, set and get password etc
	 */
    public Landlord(String name, String email, String pswd){
        super(name, email, pswd);
    }

    
	/**
	 * Method to add the property passed in to an ArrayList of properties
	 * @param p
	 */
    public void addProperty(Property p){
        properties.add(p);
    }

    
    public void addProperty(String type, int bed, int bath, boolean furn, String quad, String email){
    }

	/**
	 * Method to remove the property corresponding to the id passed in from the ArrayList of properties
	 * @param id
	 */
    public void removeProperty(int id){
        for(int i = 0; i < properties.size(); i++){
            if(properties.get(i).getID() == id){
                properties.remove(i);
            }
        }
    }

    public void payFee(int propId){
        // create payment object and set to that properties paymentInfo
    }

}

