package view;

import model.UserProfile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 
 * RegistrationGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class RegistrationGUI {

    private JComboBox userType;
    private JLabel emailLabel;
    private JLabel nameLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField emailText;    
    private JTextField nameText;
    private JPasswordField passwordText;
    private JPasswordField confirmPasswordText;
    private JButton registerButton;

    String[] userTypes = {"Renter", "Landlord"};

    public RegistrationGUI(){
        JFrame frame = new JFrame("Register as a new user");
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLabel = new JLabel("User Type:");
        userLabel.setBounds(20, 20, 80, 25);
        panel.add(userLabel);        

        userType = new JComboBox(userTypes);
        userType.setBounds(150, 20, 80, 25);
        panel.add(userType);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 50, 80, 25);
        panel.add(emailLabel);

        emailText = new JTextField(20); 
        emailText.setBounds(150, 50, 165, 25);
        panel.add(emailText);

        nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(20, 80, 80, 25);
        panel.add(nameLabel);    

        nameText = new JTextField(20); 
        nameText.setBounds(150, 80, 165, 25);
        panel.add(nameText);            
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 110, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20); 
        passwordText.setBounds(150, 110, 165, 25);
        panel.add(passwordText); 

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20, 140, 140, 25);
        panel.add(confirmPasswordLabel);

        confirmPasswordText = new JPasswordField(20); 
        confirmPasswordText.setBounds(150, 140, 165, 25);
        panel.add(confirmPasswordText);         

        registerButton = new JButton("Submit");
        registerButton.setBounds(192, 170, 80, 25);
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String newUserType = userType.getSelectedItem().toString();
                String email = emailText.getText();
                String name = nameText.getText();
                String password = String.valueOf(passwordText.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordText.getPassword());
                if(email.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "One or more fields is empty. Please try again.");
                }
                else if(!password.equals(confirmPassword)){
                    JOptionPane.showMessageDialog(frame, "Passwords do not match. Please try again.");
                }
                else{
                    UserProfile newUser = new UserProfile(name, email, password);
                    JOptionPane.showMessageDialog(frame, "Registration successful. Please log in now.");
                    Driver.newRegistrationSubmitted(newUser, newUserType);
                    frame.dispose();
                }
            }
        });
        panel.add(registerButton);

        frame.setContentPane(panel); 
        frame.setVisible(true);        
    }
}