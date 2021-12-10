package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    private JLabel welcomeLabel;
    private JButton searchButton;
    private JButton subscriptionsButton;

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

    public RenterGUI(){
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

        // initializing searchPanel

        String[] bedBathOptions = {"No preference", "1", "1+", "2", "2+", "3", "3+", "4", "4+"};
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
                Driver.getRegisteredSearchResults(propType, bed, bath, furn, quad);
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

        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(searchPanel, "2");
        panel.add(subscriptionsPanel, "3");
        layout.show(panel, "1");  
    }
}