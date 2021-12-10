package view;

import javax.swing.*;

import model.Property;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/* 
 * RenterGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class RenterGUI {
    private CardLayout layout;

    private JFrame frame = new JFrame("Renter Menu");
    private JPanel panel = new JPanel(); 
    
    private JPanel menuPanel;
    private JPanel searchPanel;       
    private JPanel subscriptionsPanel;
    private JPanel emailPanel;

    private JLabel welcomeLabel;
    private JButton searchButton;
    private JButton subscriptionsButton;
    private JButton emailButton;

    private JLabel searchLabel;
    private JLabel typeOps;        
    private JComboBox typecb;
    private JLabel bedOps;
    private JComboBox bedcb;
    private JLabel bathOps;
    private JComboBox bathcb;
    private JLabel furnOps;
    private JComboBox furncb;
    private JLabel quadOps;
    private JComboBox quadcb;
    private JButton searchPropertyButton;    
    
    private static String renterEmail;

    public RenterGUI(String email){
        
        renterEmail = email;
        
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(panel);
        frame.setVisible(true); 
        
        // initializing the menu panel and adding buttons
        menuPanel = new JPanel();
        menuPanel.setLayout(null);

        searchPanel = new JPanel();
        searchPanel.setLayout(null);  
        
        subscriptionsPanel = new JPanel();
        subscriptionsPanel.setLayout(null);         

        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setBounds(10, 20, 200, 25);
        menuPanel.add(welcomeLabel);     
        
        searchButton = new JButton("Search for Properties");
        searchButton.setBounds(10, 50, 200, 25); 
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "2");
            }
        });      
        menuPanel.add(searchButton);   
        
        subscriptionsButton = new JButton("View Subscriptions");
        subscriptionsButton.setBounds(10, 80, 200, 25); 
        subscriptionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "3");
            }
        });      
        menuPanel.add(subscriptionsButton);
        
        emailButton = new JButton("Email a landlord");
        emailButton.setBounds(10, 110, 200, 25);
        emailButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "4");
            }
        });      
        menuPanel.add(emailButton);

        // initializing searchPanel

        String[] bedBathOptions = {"No preference", "1", "2", "3", "4", "5", "6"};
        String[] propertyTypeOptions = {"No preference", "Apartment", "House", "Townhouse"};
        String[] furnishedOptions = {"No preference", "Yes", "No"};
        String[] quadrantOptions = {"No preference", "NW", "NE", "SW", "SE"};
        
        searchPanel = new JPanel();
        searchPanel.setLayout(null);

        searchLabel = new JLabel("Search for a property...");
        searchLabel.setBounds(10, 20, 200, 25);
        searchPanel.add(searchLabel);

        typeOps = new JLabel("Desired property type:");
        typeOps.setBounds(10, 80, 200, 25);
        searchPanel.add(typeOps);

        typecb = new JComboBox(propertyTypeOptions);
        typecb.setBounds(250, 80, 110, 25);
        searchPanel.add(typecb);

        bedOps = new JLabel("Desired number of bedrooms:");
        bedOps.setBounds(10, 110, 200, 25);
        searchPanel.add(bedOps);

        bedcb = new JComboBox(bedBathOptions);
        bedcb.setBounds(250, 110, 110, 25);
        searchPanel.add(bedcb);

        bathOps = new JLabel("Desired number of bathrooms:");
        bathOps.setBounds(10, 140, 200, 25);
        searchPanel.add(bathOps);

        bathcb = new JComboBox(bedBathOptions);
        bathcb.setBounds(250, 140, 110, 25);
        searchPanel.add(bathcb);

        furnOps = new JLabel("Furnished property desired:");
        furnOps.setBounds(10, 170, 200, 25);
        searchPanel.add(furnOps);

        furncb = new JComboBox(furnishedOptions);
        furncb.setBounds(250, 170, 110, 25);
        searchPanel.add(furncb);

        quadOps = new JLabel("Quadrant desired:");
        quadOps.setBounds(10, 200, 200, 25);
        searchPanel.add(quadOps);

        quadcb = new JComboBox(quadrantOptions);
        quadcb.setBounds(250, 200, 110, 25);
        searchPanel.add(quadcb);

        searchPropertyButton = new JButton("Search");
        searchPropertyButton.setBounds(175, 230, 80, 25);

        searchPropertyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String propType = typecb.getSelectedItem().toString();
                String bed = bedcb.getSelectedItem().toString();
                String bath = bathcb.getSelectedItem().toString();
                String furn = furncb.getSelectedItem().toString();
                String quad = quadcb.getSelectedItem().toString();
                Driver.getRegisteredSearchResults(propType, bed, bath, furn, quad, renterEmail);
                frame.dispose();
            }
        });
        searchPanel.add(searchPropertyButton);

        JButton backButton1 = new JButton("Back to menu");
        backButton1.setBounds(30, 400, 150, 25);
        backButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "1");
            }
        });
        searchPanel.add(backButton1);   
        
        
        //initializing emailPanel
        emailPanel = new JPanel();
        emailPanel.setLayout(null);

        JButton backButton2 = new JButton("Back to menu");
        backButton2.setBounds(30, 400, 150, 25);
        backButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "1");
            }
        });
        emailPanel.add(backButton2); 

        ArrayList<Property> activeListings = Driver.getAllPropertiesManager();
        ArrayList<String> activeListingIDs = new ArrayList<String>();

        for(Property x : activeListings){
            if(x.getStatus().equals("Active")){
                activeListingIDs.add(String.valueOf(x.getID()));
            }
        }

        JLabel propIDOps = new JLabel("ID of interested property:");
        propIDOps.setBounds(30, 30, 150, 25);
        emailPanel.add(propIDOps);

        JComboBox propIDcb = new JComboBox(activeListingIDs.toArray());
        propIDcb.setBounds(30, 60, 50, 25);
        emailPanel.add(propIDcb);

        JLabel messageLab = new JLabel("Message:");
        messageLab.setBounds(180, 30, 100, 25);
        emailPanel.add(messageLab);

        JTextField messageText = new JTextField(20); 
        messageText.setBounds(180, 60, 450, 25);
        emailPanel.add(messageText);

        JButton sendEmailButton = new JButton("Send Email");
        sendEmailButton.setBounds(250, 90, 150, 25);
        sendEmailButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.sendEmailToLandlord(email, Integer.parseInt(propIDcb.getSelectedItem().toString()), messageText.getText().toString());
                JOptionPane.showMessageDialog(frame, "Email has been sent! Click okay to continue.");
                layout.show(panel, "1");
            }
        });
        emailPanel.add(sendEmailButton); 


        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(searchPanel, "2");
        panel.add(subscriptionsPanel, "3");
        panel.add(emailPanel, "4");
        layout.show(panel, "1");  
    }
}