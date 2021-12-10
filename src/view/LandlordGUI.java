package view;

import model.Property;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

/* 
 * LandlordGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class LandlordGUI {

    // private member variables to hold landlord GUI components
    private CardLayout layout;
    private JFrame frame = new JFrame("Landlord Menu");
    private JPanel panel = new JPanel();

    private JPanel menuPanel, registerPanel, paymentPanel, listingStatePanel;

    private JLabel welcomeLabel, propertyLabel, addressLabel, typeOps, bedOps, bathOps, furnOps, quadOps, rentLabel, paymentIDLabel;
    private JLabel paymentLabel, paymentTitleLabel, paymentFeeLabel, paymentDaysLabel, paymentRegistrationLabel, paymentRegistrationFeeLabel;
    private JLabel listingTitleLabel, listingIDLabel, listingLabel;

    private JButton registerButton, submitButton, propertyButton, paymentButton, paymentMenuButton, changeListingButton, backButton1, backButton2, backButton3, backButton4, stateChangeButton;

    private JTextField addressText, rentText, paymentText, paymentRegistrationText, paymentIDText, listingIDText;

    private JComboBox typecb, bedcb, bathcb, furncb, quadcb, listingcb;

    private static String fee;
    private static String numberOfDays;

    public LandlordGUI(int landlordID){

        fee = Driver.getPaymentFee();
        numberOfDays = Driver.getNumberOfFeeDays();      

        // initialize the JFrame object
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);            

        // initializing the menu panel and adding buttons
        menuPanel = new JPanel();
        menuPanel.setLayout(null);

        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setBounds(10, 20, 250, 25);
        menuPanel.add(welcomeLabel);

        registerButton = new JButton("Register Property");
        registerButton.setBounds(10, 50, 250, 25); 
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "2");
            }
        });  
        menuPanel.add(registerButton);   
        
        paymentMenuButton = new JButton("Renew Payment");
        paymentMenuButton.setBounds(10, 80, 250, 25); 
        paymentMenuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "3");
            }
        });
        menuPanel.add(paymentMenuButton);  

        propertyButton = new JButton("Manage Properties");
        propertyButton.setBounds(10, 110, 250, 25); 
        propertyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.managePropertiesButtonPressed(landlordID);
                frame.dispose();
            }
        });          
        menuPanel.add(propertyButton);   

        changeListingButton = new JButton("Change Property State");
        changeListingButton.setBounds(10, 140, 250, 25); 
        changeListingButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "4");
            }
        });          
        menuPanel.add(changeListingButton);                    

        // intializing the property registration panel and adding the necessary components
        registerPanel = new JPanel();
        registerPanel.setLayout(null);

        String[] bedBathOptions = {"1", "2", "3", "4", "5", "6"};
        String[] propertyTypeOptions = {"Apartment", "House", "Townhouse"};
        String[] furnishedOptions = {"Yes", "No"};
        String[] quadrantOptions = {"NW", "NE", "SW", "SE"};
        
        propertyLabel = new JLabel("New Property Registration:");
        propertyLabel.setBounds(10, 20, 200, 25);
        registerPanel.add(propertyLabel);

        addressLabel = new JLabel("Property Address:");
        addressLabel.setBounds(10, 50, 200, 25);
        registerPanel.add(addressLabel);  
        
        addressText = new JTextField(20); 
        addressText.setBounds(250, 50, 300, 25);
        registerPanel.add(addressText);          

        typeOps = new JLabel("Property Type:");
        typeOps.setBounds(10, 80, 200, 25);
        registerPanel.add(typeOps);

        typecb = new JComboBox(propertyTypeOptions);
        typecb.setBounds(250, 80, 300, 25);
        registerPanel.add(typecb);

        bedOps = new JLabel("Number of Bedrooms:");
        bedOps.setBounds(10, 110, 200, 25);
        registerPanel.add(bedOps);

        bedcb = new JComboBox(bedBathOptions);
        bedcb.setBounds(250, 110, 300, 25);
        registerPanel.add(bedcb);

        bathOps = new JLabel("Number of Bathrooms:");
        bathOps.setBounds(10, 140, 200, 25);
        registerPanel.add(bathOps);

        bathcb = new JComboBox(bedBathOptions);
        bathcb.setBounds(250, 140, 300, 25);
        registerPanel.add(bathcb);

        furnOps = new JLabel("Is the Property Furnished?");
        furnOps.setBounds(10, 170, 200, 25);
        registerPanel.add(furnOps);

        furncb = new JComboBox(furnishedOptions);
        furncb.setBounds(250, 170, 300, 25);
        registerPanel.add(furncb);

        quadOps = new JLabel("Property Quadrant:");
        quadOps.setBounds(10, 200, 200, 25);
        registerPanel.add(quadOps);

        quadcb = new JComboBox(quadrantOptions);
        quadcb.setBounds(250, 200, 300, 25);
        registerPanel.add(quadcb);

        rentLabel = new JLabel("Rent Price:");
        rentLabel.setBounds(10, 230, 200, 25);
        registerPanel.add(rentLabel);        

        rentText = new JTextField(20); 
        rentText.setBounds(250, 230, 300, 25);
        registerPanel.add(rentText);  

        paymentRegistrationLabel = new JLabel("Payment Information: A payment fee of $" + fee + " is required and will be valid for " + numberOfDays + " days.");
        paymentRegistrationLabel.setBounds(10, 290, 600, 25);
        registerPanel.add(paymentRegistrationLabel);  

        paymentRegistrationFeeLabel = new JLabel("Payment Information:");
        paymentRegistrationFeeLabel.setBounds(10, 320, 200, 25);
        registerPanel.add(paymentRegistrationLabel); 
        
        paymentRegistrationText = new JTextField(20); 
        paymentRegistrationText.setBounds(250, 320, 300, 25);        
        registerPanel.add(paymentRegistrationText); 

        submitButton = new JButton("Submit Registration and Payment");
        submitButton.setBounds(250, 380, 300, 25); 
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(addressText.getText().isEmpty() || rentText.getText().isEmpty() || paymentRegistrationText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "One or more fields is empty. Please try again.");
                }
                else{
                    try{
                        LocalDate c = LocalDate.now().plusDays(Long.valueOf(numberOfDays));
                        Date expiryDate = Date.valueOf(c.toString());
                        int ownerID = landlordID;
                        int rentPrice = Integer.parseInt(rentText.getText().toString());
                        if(rentPrice < 0){
                            JOptionPane.showMessageDialog(frame, "Rent price is not valid. Please try again.");
                            return;
                        }
                        Property newProperty = new Property(1, addressText.getText(), typecb.getSelectedItem().toString(), Integer.parseInt(bedcb.getSelectedItem().toString()), 
                        Integer.parseInt(bathcb.getSelectedItem().toString()), Boolean.parseBoolean(furncb.getSelectedItem().toString()), 
                        quadcb.getSelectedItem().toString(), ownerID, rentPrice, expiryDate, "Active");
                        Driver.submitPropertyRegistrationPressed(newProperty);                  
                        JOptionPane.showMessageDialog(frame, "Property has been successfully registered and payment has been processed!");
                        layout.show(panel, "1"); 
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(frame, "Rent price is not valid. Please try again.");
                    }
                }
            }
        });          
        registerPanel.add(submitButton); 

        backButton1 = new JButton("Back to menu");
        backButton1.setBounds(30, 400, 150, 25);
        backButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "1");
            }
        });
        registerPanel.add(backButton1);

        // initializing the property payment panel and adding necessary components

        paymentPanel = new JPanel();
        paymentPanel.setLayout(null);

        paymentTitleLabel = new JLabel("Renew Property Payment:");
        paymentTitleLabel.setBounds(10, 20, 200, 25);
        paymentPanel.add(paymentTitleLabel);

        paymentFeeLabel = new JLabel("Payment Fee: $" + fee);
        paymentFeeLabel.setBounds(10, 50, 200, 25);
        paymentPanel.add(paymentFeeLabel);   
        
        paymentDaysLabel = new JLabel("Payment is valid for: " + numberOfDays + " days.");
        paymentDaysLabel.setBounds(10, 80, 200, 25);
        paymentPanel.add(paymentDaysLabel);   

        paymentIDLabel = new JLabel("Property ID for Renewal:");
        paymentIDLabel.setBounds(10, 110, 200, 25);
        paymentPanel.add(paymentIDLabel);    
        
        paymentIDText = new JTextField(20); 
        paymentIDText.setBounds(300, 110, 200, 25);        
        paymentPanel.add(paymentIDText);          

        paymentLabel = new JLabel("Payment Information:");
        paymentLabel.setBounds(10, 140, 200, 25);
        paymentPanel.add(paymentLabel);  

        paymentText = new JTextField(20); 
        paymentText.setBounds(300, 140, 200, 25);        
        paymentPanel.add(paymentText);  

        paymentButton = new JButton("Submit Payment Renewal");
        paymentButton.setBounds(320, 170, 160, 25); 
        paymentButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(paymentText.getText().isEmpty() || paymentIDText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "One or more fields is empty. Please try again.");
                }
                else{
                    try{
                        int propertyID = Integer.parseInt(paymentIDText.getText().toString());
                        if(propertyID < 0){
                            JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again.");
                            return;
                        }
                        Driver.submitPropertyRenewalPaymentPressed(propertyID);
                        JOptionPane.showMessageDialog(frame, "Renewal fee has been paid and the property listing is now active! Click okay to continue.");
                        layout.show(panel, "1");
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again.");
                    }
                }
            }
        });          
        paymentPanel.add(paymentButton);   
        
        backButton2 = new JButton("Back to menu");
        backButton2.setBounds(30, 400, 150, 25);
        backButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "1");
            }
        });
        paymentPanel.add(backButton2);     

        // panel for changing listing state

        listingStatePanel = new JPanel();
        listingStatePanel.setLayout(null);

        listingTitleLabel = new JLabel("Change Listing State:");
        listingTitleLabel.setBounds(10, 20, 200, 25);
        listingStatePanel.add(listingTitleLabel);

        listingIDLabel = new JLabel("Property ID for State Change:");
        listingIDLabel.setBounds(10, 50, 200, 25);
        listingStatePanel.add(listingIDLabel);    
        
        listingIDText = new JTextField(20); 
        listingIDText.setBounds(300, 50, 200, 25);        
        listingStatePanel.add(listingIDText);          

        listingLabel = new JLabel("New Listing Status:");
        listingLabel.setBounds(10, 80, 200, 25);
        listingStatePanel.add(listingLabel);  

        String[] stateOptions = {"Active", "Rented", "Cancelled", "Suspended"};

        listingcb = new JComboBox(stateOptions);
        listingcb.setBounds(300, 80, 200, 25);
        listingStatePanel.add(listingcb);

        stateChangeButton = new JButton("Submit Change");
        stateChangeButton.setBounds(320, 110, 160, 25);         
        stateChangeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int listingID = Integer.parseInt(listingIDText.getText().toString());
                    if(listingID < 0){
                        JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again.");
                        return;
                    }
                    String newState = listingcb.getSelectedItem().toString();
                    Driver.changeListingState(listingID, newState);
                    JOptionPane.showMessageDialog(frame, "Listing state has been changed. Click okay to continue");
                    layout.show(panel, "1");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again");
                }
            }
        });          
        listingStatePanel.add(stateChangeButton);          

        backButton4 = new JButton("Back to menu");
        backButton4.setBounds(30, 400, 150, 25);
        backButton4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "1");
            }
        });
        listingStatePanel.add(backButton4);

        // initialize the card layout and add panels so that users can move between pages 
        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(registerPanel, "2");
        panel.add(paymentPanel, "3");
        panel.add(listingStatePanel, "4");
        layout.show(panel, "1");        
    }
}
