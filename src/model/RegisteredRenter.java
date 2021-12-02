package model;

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

    public RegisteredRenter(String email, String pswd){
        super(email, pswd);
    }

    public void register(Observer o){
        observers.add(o);
        o.update(filteredProperties);
    }

    public void remove(Observer o){
        observers.remove(o);
    }

    public void notifyObserver(){
        for(int i = 0; i < observers.size(); i++){
            Observer o = observers.get(i);
            o.update(filteredProperties);
        }
    }

    public void unsubscribe(){
    }

    public void addProperty(Property p){
        propertiesRented.add(p);
    }

}
