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

    public Search(){
    }

    public Search(String type, String bed, String bath, String furn, String quad){
        this.propertyType = type;
        this.noBed = bed;
        this.noBath = bath;
        this.isFurnished = furn;
        this.quadrant = quad;
    }

    public void setType(String type){
        this.propertyType = type;
    }

    public void setBed(String bed){
        this.noBed = bed;
    }

    public void setBath(String bath){
        this.noBath = bath;
    }

    public void setFurnished(String furn){
        this.isFurnished = furn;
    }

    public void setQuadrant(String quad){
        this.quadrant = quad;
    }

    public String getType(){
        return this.propertyType;
    }

    public String getBed(){
        return this.noBed;
    }
    
    public String getBath(){
        return this.noBath;
    }

    public String getFurnished(){
        return this.isFurnished;
    }

    public String getQuadrant(){
        return this.quadrant;
    }

}
