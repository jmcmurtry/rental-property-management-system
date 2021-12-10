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
    
	/**
	 * Setter method for Username. Takes in a String parameter
	 * @param name
	 */
    public void setName(String name){
        this.name = name;
    }
    
	/**
	 * Setter method for the email address. Takes in a String parameter
	 * @param email
	 */
    public void setEmail(String email){
        this.email = email;
    }

	/**
	 * Setter method for the password. Takes in a String parameter
	 * @param pswd
	 */
    public void setPassword(String pswd){
        this.password = pswd;
    }
    
	/**
	 * Setter method for the search criteria of a user. Takes in a argument of type Search
	 * @param criteria
	 */
    public void setSearch(Search criteria){
        this.searchCriteria = criteria;
    }
   
	/**
	 * Getter method for UserID
	 * @return returns an int corresponding to the UserID
	 */
    public int getID(){
        return this.userID;
    }
    
	/**
	 * Getter method for emailID
	 * @return returns a String corresponding to the email address
	 */
    public String getEmail(){
        return this.email;
    }
    
	/**
	 * Getter method for the username
	 * @return returns a string corresponding to the user's name
	 */
    public String getName(){
        return this.name;
    }

	/**
	 * Getter method for the user's password
	 * @return returns a String corresponding to the user's password
	 */
    public String getPassword(){
        return this.password;
    }
    
	/**
	 * Getter method for the user's search criteria
	 * @return returns a Search object corresponding to the user's search criteria
	 */
    public Search getSearch(){
        return this.searchCriteria;
    }


}

