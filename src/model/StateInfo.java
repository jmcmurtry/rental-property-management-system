package model;

public class StateInfo {
    private String state;
    private Date startDate;
    private Date endDate;
    private int propertyID;

    public StateInfo(String state, Date start, Date end, int id){
        this.state = state;
        this.startDate = start;
        this.endDate = end;
        this.propertyID = id;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setStartDate(Date start){
        this.startDate = start;
    }

    public void setEndDate(Date end){
        this.endDate = end;
    }

    public void setPropertyID(int id){
        this.propertyID = id;
    }

    public String getState(){
        return this.state;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public int getPropertyID(){
        return this.propertyID;
    }
}
