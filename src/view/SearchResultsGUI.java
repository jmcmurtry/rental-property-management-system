package view;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



/* 
 * SearchResultsGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra 30092921
 * Harrison Mondragon 30088805
 */

public class SearchResultsGUI {

    private JFrame frame = new JFrame();
    private JTable table;

    public SearchResultsGUI(ArrayList<Property> PropertyList){

        Object[][] data = new Object[PropertyList.size()][7];

        for(int i = 0; i < PropertyList.size(); i++){
          int j = 0;
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

        String[] cNames = {"Address", "Property Type", "Beds", "Baths", "Funished?", "Quadrant", "Rent Price ($)"};
          
        table = new JTable(data, cNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);            
    }
}
