package model;

/* 
 * Subject.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class UserProfile {
    private int userID;
    private String email;
    private String name;
    private String password;
    private Search searchCriteria;

    public UserProfile(String email, String pswd){
    }

    public void setEmail(String email){
    }

    public void setName(String email){
    }

    public void setPassword(String email){
    }

    public void setSearch(Search criteria){
    }

    public int getID(){
        return this.userID;
    }

    public String getEmail(){
        return this.email;
    }
    
    public String getName(){
        return this.name;
    }

    public String getPswd(){
        return this.password;
    }

    public Search getSearch(){
        return this.searchCriteria;
    }


}
