package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 
 * SearchGUI.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public class SearchGUI {

    private JFrame frame;
    private JPanel panel;
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
    private JButton searchButton;

    public SearchGUI(){

        String[] bedBathOptions = {"No preference", "1", "2", "3", "4", "5", "6"};
        String[] propertyTypeOptions = {"No preference", "Apartment", "House", "Townhouse"};
        String[] furnishedOptions = {"No preference", "Yes", "No"};
        String[] quadrantOptions = {"No preference", "NW", "NE", "SW", "SE"};
        
        frame = new JFrame("Search");
        panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        searchLabel = new JLabel("Search for a property...");
        searchLabel.setBounds(10, 20, 200, 25);
        panel.add(searchLabel);

        typeOps = new JLabel("Desired property type:");
        typeOps.setBounds(10, 80, 200, 25);
        panel.add(typeOps);

        typecb = new JComboBox(propertyTypeOptions);
        typecb.setBounds(250, 80, 110, 25);
        panel.add(typecb);

        bedOps = new JLabel("Desired number of bedrooms:");
        bedOps.setBounds(10, 110, 200, 25);
        panel.add(bedOps);

        bedcb = new JComboBox(bedBathOptions);
        bedcb.setBounds(250, 110, 110, 25);
        panel.add(bedcb);

        bathOps = new JLabel("Desired number of bathrooms:");
        bathOps.setBounds(10, 140, 200, 25);
        panel.add(bathOps);

        bathcb = new JComboBox(bedBathOptions);
        bathcb.setBounds(250, 140, 110, 25);
        panel.add(bathcb);

        furnOps = new JLabel("Furnished property desired:");
        furnOps.setBounds(10, 170, 200, 25);
        panel.add(furnOps);

        furncb = new JComboBox(furnishedOptions);
        furncb.setBounds(250, 170, 110, 25);
        panel.add(furncb);

        quadOps = new JLabel("Quadrant desired:");
        quadOps.setBounds(10, 200, 200, 25);
        panel.add(quadOps);

        quadcb = new JComboBox(quadrantOptions);
        quadcb.setBounds(250, 200, 110, 25);
        panel.add(quadcb);

        searchButton = new JButton("Search");
        searchButton.setBounds(175, 230, 80, 25);

        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String propType = typecb.getSelectedItem().toString();
                String bed = bedcb.getSelectedItem().toString();
                String bath = bathcb.getSelectedItem().toString();
                String furn = furncb.getSelectedItem().toString();
                String quad = quadcb.getSelectedItem().toString();
                Driver.getSearchResults(propType, bed, bath, furn, quad);
                frame.dispose();
            }
        });
        panel.add(searchButton);

        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
