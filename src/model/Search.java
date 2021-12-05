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
    private int noBed;
    private int noBath;
    private boolean isFurnished;
    private String quadrant;

    public Search(){
    }

    public Search(String type, int bed, int bath, boolean furn, String quad){
        this.propertyType = type;
        this.noBed = bed;
        this.noBath = bath;
        this.isFurnished = furn;
        this.quadrant = quad;
    }

    public void setType(String type){
        this.propertyType = type;
    }

    public void setBed(int bed){
        this.noBed = bed;
    }

    public void setBath(int bath){
        this.noBath = bath;
    }

    public void setFurnished(boolean furn){
        this.isFurnished = furn;
    }

    public void setQuadrant(String quad){
        this.quadrant = quad;
    }

    public String getType(){
        return this.propertyType;
    }

    public int getBed(){
        return this.noBed;
    }
    
    public int getBath(){
        return this.noBath;
    }

    public boolean getFurnished(){
        return this.isFurnished;
    }

    public String getQuadrant(){
        return this.quadrant;
    }

}
