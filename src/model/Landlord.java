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

    public Landlord(String name, String email, String pswd){
        super(name, email, pswd);
    }

    public void addProperty(Property p){
        properties.add(p);
    }

    public void addProperty(String type, int bed, int bath, boolean furn, String quad, String email){
    }

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
