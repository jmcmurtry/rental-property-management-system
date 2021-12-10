package model;

/* 
 * Search.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Search {
    private String propertyType;
    private String noBed;
    private String noBath;
    private String isFurnished;
    private String quadrant;

    
    /**
     * Default constructor for Search class
     */
    public Search(){
    }

   /**
    *  Constructor for the Search class
    * @param type
    * @param bed
    * @param bath
    * @param furn
    * @param quad
    */
    public Search(String type, String bed, String bath, String furn, String quad){
        this.propertyType = type;
        this.noBed = bed;
        this.noBath = bath;
        this.isFurnished = furn;
        this.quadrant = quad;
    }

    /**
     * Setter for the tyoe of property
     * @param type
     */
    public void setType(String type){
        this.propertyType = type;
    }

    /**
     * Setter for the number of beds in a property
     * @param bed
     */
    public void setBed(String bed){
        this.noBed = bed;
    }
    
    /**
     * Setter for the number of bathrooms in a property
     * @param bath
     */
    public void setBath(String bath){
        this.noBath = bath;
    }

    /**
     * Setter for the boolean furnished. If a property is furnised or not
     * @param furn
     */
    public void setFurnished(String furn){
        this.isFurnished = furn;
    }

    /**
     * Setter for the quadrant that the property belongs to
     * @param quad
     */
    public void setQuadrant(String quad){
        this.quadrant = quad;
    }

  /**
  * Getter of the tyoe of property
  * @return the propertyType of the property
  */
    public String getType(){
        return this.propertyType;
    }
    /**
     * Getter of the number of bedrooms in a property
     * @return an int correspong to the number of beds in the property
     */
    public String getBed(){
        return this.noBed;
    }
    /**
     * Getter of the number of bathrooms in a property
     * @return an int corresponding to he number of beds in the property
     */
    public String getBath(){
        return this.noBath;
    }
    /**
     * Getter of the isFurnished 
     * @return a boolean corresponding to the isFurnished of the property
     */
    public String getFurnished(){
        return this.isFurnished;
    }
    /**
     * Getter of the quadrant that the property belongs to
     * @return a string corresponding to the quadrant that the property belongs to
     */
    public String getQuadrant(){
        return this.quadrant;
    }

}

