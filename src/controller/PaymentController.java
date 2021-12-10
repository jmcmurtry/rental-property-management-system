package controller;

import java.sql.*;

public class PaymentController extends AppController{
    public PaymentController(){
        super();
    }

    public void setFeeInfo(double fee, int period){   
        try{
            deleteFeeInfo(fee, period);
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

    public void deleteFeeInfo(double fee, int period){   
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
