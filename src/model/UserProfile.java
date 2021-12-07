package model;

/* 
 * UserProfile.java
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
    public static int idGenerate = 1;

    public UserProfile(String name, String email, String pswd){
        this.userID = idGenerate;
        idGenerate++;
        this.name = name;
        this.email = email;
        this.password = pswd;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String pswd){
        this.password = pswd;
    }

    public void setSearch(Search criteria){
        this.searchCriteria = criteria;
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
