package model;

/* 
 * Date.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class Date {
    private int year;
    private int month;
    private int day;
    
    public Date(int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public void setYear(int y){
        this.year = y;
    }

    public void setMonth(int m){
        this.month = m;
    }

    public void setDay(int d){
        this.day = d;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

}
