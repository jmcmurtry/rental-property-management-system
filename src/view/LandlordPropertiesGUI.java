package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Property;
import java.util.ArrayList;

public class LandlordPropertiesGUI {

    private JFrame frame = new JFrame("Landlord Menu");
    private JPanel panel;
    private JTable table;
    private JButton backButton3;

    public LandlordPropertiesGUI(ArrayList<Property> landlordProperties, int landlordID){

        panel = new JPanel();
        BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bl);

        BoxLayout bLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bLayout);        

        if(!landlordProperties.isEmpty()){
            Object[][] data = new Object[landlordProperties.size()][9];

            for(int i = 0; i < landlordProperties.size(); i++){
            int j = 0;
            data[i][j] = landlordProperties.get(i).getID();
            j++;
            data[i][j] = landlordProperties.get(i).getStatus();
            j++;          
            data[i][j] = landlordProperties.get(i).getAddress();
            j++;
            data[i][j] = landlordProperties.get(i).getType();
            j++;
            data[i][j] = landlordProperties.get(i).getBed();
            j++;
            data[i][j] = landlordProperties.get(i).getBath();
            j++;
            data[i][j] = landlordProperties.get(i).getFurnished();
            j++;
            data[i][j] = landlordProperties.get(i).getQuadrant();
            j++;
            data[i][j] = landlordProperties.get(i).getRentPrice();
            }

            String[] cNames = {"Property ID", "Status", "Address", "Property Type", "Beds", "Baths", "Funished?", "Quadrant", "Rent Price ($)"};
            
            table = new JTable(data, cNames);
            table.setBounds(30, 40, 200, 300);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        backButton3 = new JButton("Back to menu");
        backButton3.setBounds(30, 400, 150, 25);
        backButton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.backToLandlordMenu(landlordID);
                frame.dispose();
            }
        });
        panel.add(backButton3); 

        frame.add(panel);         
        panel.add(scrollPane);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    
    }
}
