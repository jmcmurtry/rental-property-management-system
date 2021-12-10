package view;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/* 
 * RegisteredSearchResultsGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class RegisteredSearchResultsGUI {

    private JFrame frame = new JFrame();
    private JTable table;
    private String renterEmail;

    public RegisteredSearchResultsGUI(ArrayList<Property> PropertyList, String email){

        JPanel panel = new JPanel();

        renterEmail = email;

        BoxLayout bLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bLayout);          

        Object[][] data = new Object[PropertyList.size()][8];

        for(int i = 0; i < PropertyList.size(); i++){
          int j = 0;
          data[i][j] = PropertyList.get(i).getID();
          j++;          
          data[i][j] = PropertyList.get(i).getAddress();
          j++;
          data[i][j] = PropertyList.get(i).getType();
          j++;
          data[i][j] = PropertyList.get(i).getBed();
          j++;
          data[i][j] = PropertyList.get(i).getBath();
          j++;
          data[i][j] = PropertyList.get(i).getFurnished();
          j++;
          data[i][j] = PropertyList.get(i).getQuadrant();
          j++;
          data[i][j] = PropertyList.get(i).getRentPrice();
        }

        String[] cNames = {"Property ID", "Address", "Property Type", "Beds", "Baths", "Funished?", "Quadrant", "Rent Price ($)"};
          
        table = new JTable(data, cNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton backButton1 = new JButton("Back to menu");
        backButton1.setBounds(30, 400, 150, 25);
        backButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.backToRegisteredRenterMenu(renterEmail);
                frame.dispose();
            }
        });
        panel.add(backButton1);           

        frame.add(panel);
        panel.add(scrollPane);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);            
    }
}
