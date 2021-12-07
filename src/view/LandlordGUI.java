import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    private JPanel menuPanel;
    private JPanel registerPanel;
    private JPanel paymentPanel;
    private JPanel propertyPanel;

    private JLabel welcomeLabel;
    private JButton registerButton;
    private JLabel propertyLabel;
    private JLabel addressLabel;
    private JTextField addressText;
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
    private JLabel rentLabel;
    private JTextField rentText;
    private JButton submitButton;
    private JButton propertyButton;
    private JButton paymentButton;
    private JLabel paymentLabel;
    private JLabel paymentTitleLabel;
    private JTextField paymentText;

    public LandlordGUI(){

        // initialize the JFrame object
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(panel);
        frame.setVisible(true);            

        // initializing the menu panel and adding buttons
        menuPanel = new JPanel();
        menuPanel.setLayout(null);

        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setBounds(10, 20, 200, 25);
        menuPanel.add(welcomeLabel);

        registerButton = new JButton("Register Property");
        registerButton.setBounds(10, 50, 200, 25); 
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "2");
            }
        });         
        menuPanel.add(registerButton);  

        propertyButton = new JButton("Manage Properties");
        propertyButton.setBounds(10, 80, 200, 25); 
        propertyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(panel, "4");
            }
        });          
        menuPanel.add(propertyButton);            

        // intializing the property registration panel and adding the necessary components
        registerPanel = new JPanel();
        registerPanel.setLayout(null);

        String[] bedBathOptions = {"1", "2", "3", "4", "4+"};
        String[] propertyTypeOptions = {"Apartment", "House", "Townhouse"};
        String[] furnishedOptions = {"Yes", "No"};
        String[] quadrantOptions = {"NW", "NE", "SW", "SE"};
        
        propertyLabel = new JLabel("New Property Registration");
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

        submitButton = new JButton("Submit Registration");
        submitButton.setBounds(300, 260, 200, 25); 
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(addressText.getText().isEmpty() || rentText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "One or more fields is empty. Please try again.");
                }
                else{
                    Driver.submitPropertyRegistrationPressed();
                    JOptionPane.showMessageDialog(frame, "Property has been successfully registered! Click okay to proceed with payment.");
                    layout.show(panel, "3");
                }
            }
        });          
        registerPanel.add(submitButton); 

        // initializing the property payment panel and adding necessary components

        paymentPanel = new JPanel();
        paymentPanel.setLayout(null);

        paymentTitleLabel = new JLabel("Property Registration Payment:");
        paymentTitleLabel.setBounds(10, 20, 200, 25);
        paymentPanel.add(paymentTitleLabel);

        paymentLabel = new JLabel("Payment Information:");
        paymentLabel.setBounds(10, 50, 200, 25);
        paymentPanel.add(paymentLabel);  

        paymentText = new JTextField(20); 
        paymentText.setBounds(300, 50, 200, 25);        
        paymentPanel.add(paymentText); 

        paymentButton = new JButton("Submit Payment");
        paymentButton.setBounds(320, 80, 160, 25); 
        paymentButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(paymentText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "No payment information entered. Please try again.");
                }
                else{
                    Driver.submitPropertyPaymentPressed();
                    JOptionPane.showMessageDialog(frame, "Fee has been paid and the property listing is now active! Click okay to continue.");
                    layout.show(panel, "1");
                }
            }
        });          
        paymentPanel.add(paymentButton);         

        // initializing the manage property panel and adding necessary components

        propertyPanel = new JPanel();
        propertyPanel.setLayout(null);

        // initialize the card layout and add panels so that users can move between pages 
        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(registerPanel, "2");
        panel.add(paymentPanel, "3");
        panel.add(propertyPanel, "4");
        layout.show(panel, "1");        
    }
}
