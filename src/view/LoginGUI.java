import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 
 * LoginGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class LoginGUI {

    private JLabel userLabel;
    private JTextField usernameText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton guestButton;
    private JLabel successfulLogin;
    private JButton registerButton;

    public LoginGUI(){

        JFrame frame = new JFrame("Welcome");
        JPanel loginPanel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginPanel);   
        loginPanel.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userLabel);

        usernameText = new JTextField(20); 
        usernameText.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameText);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);

        passwordText = new JPasswordField(20); 
        passwordText.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(20, 80, 80, 25);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = usernameText.getText();
                String password = passwordText.getText();
                System.out.println(username + ", " + password);
                
            }
        });
        loginPanel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(20, 110, 80, 25);
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.registerButtonPressed();
                frame.dispose();
            }
        });
        loginPanel.add(registerButton);        

        successfulLogin = new JLabel("");
        successfulLogin.setBounds(10, 110, 300, 25);
        loginPanel.add(successfulLogin);

        guestButton = new JButton("Continue as guest");
        guestButton.setBounds(120, 80, 160, 25);
        guestButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            }
        });   
        loginPanel.add(guestButton);             

        frame.setContentPane(loginPanel); 
        frame.setVisible(true);
    }       
}
