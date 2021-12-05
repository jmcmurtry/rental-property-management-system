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
    private JPanel searchPanel;

    private JLabel welcomeLabel;
    private JButton registerButton;
    private JButton searchButton;

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

        searchButton = new JButton("Search Properties");
        searchButton.setBounds(10, 80, 200, 25);  
        menuPanel.add(searchButton);   

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
        registerPanel.add(submitButton);      

        // intialize the card layout and add panels so that users can move between pages 
        layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(menuPanel, "1");
        panel.add(registerPanel, "2");
        layout.show(panel, "1");        
    }
}
