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

        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(searchPanel, "2");
        panel.add(subscriptionsPanel, "3");
        layout.show(panel, "1");  
    }
}