package controller;

import java.sql.*;

public class PaymentController extends AppController{
    
    /**
    * Constructor - allows access to database
    */
    public PaymentController(){
        super();
    }

    /**
    * updates the payment fee and period in the database
    * @param fee : the new payment fee
    * @param period : the new payment period
    */
    public void setFeeInfo(double fee, int period){   
        try{
            deleteFeeInfo();
            String query =  "INSERT INTO fee_info(fee, numDays) VALUES (?, ?)";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.setDouble(1, fee);
            myStmt.setInt(2, period);
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
    }

    /**
    * retrieves the current payment fee from the database
    * @return : returns a String representing the payment fee
    */
    public String getPaymentFee(){   
        try{
            String query = "SELECT fee FROM fee_info WHERE id = 1";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                return String.valueOf(results.getDouble(1));
            }
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
        return "";
    }

    /**
    * retrieves the current payment period from the database
    * @return : returns a String representing the payment period in days
    */
    public String getNumberOfFeeDays(){   
        try{
            String query = "SELECT numDays FROM fee_info WHERE id = 1";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                return String.valueOf(results.getInt(1));
            }
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
        return "";
    }

    /**
    * deletes the payment fee and period in the database
    */
    public void deleteFeeInfo(){   
        try{
            String query = "DELETE FROM fee_info WHERE id = '1'";
            PreparedStatement myStmt = dbConnecter.prepareStatement(query);
            myStmt.executeUpdate();
            myStmt.close();
        }catch(Exception e){
			e.printStackTrace();
		}  
    }
}
