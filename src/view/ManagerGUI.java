package view;

import javax.swing.*;

import model.Property;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ManagerGUI {
    // initializing
    private CardLayout layout;
    private JFrame frame = new JFrame("Manager Menu");
    private JPanel masterPanel = new JPanel();

    // pannels
    private JPanel menuPanel;
    private JPanel setChangeFeePanel;
    private JPanel accessAllInfoPanel;
    private JPanel genReportPanel;
    private JPanel listingStatePanel;

    private JLabel menuLabel;

    // buttons on menuPannel
    private JButton setChangeFeeButton;
    private JButton accessAllInfoButton;
    private JButton genReportButton;
    private JButton changeStateButton;

    // setChangefee components
    private JLabel currentFeeDays;
    private JLabel setChangeFeeDirections;
    private JLabel feePriceLabel;
    private JLabel feePeriodLabel;
    private JTextField feePrice;
    private JTextField feePeriod;
    private JButton submitFeeChanges;

    public ManagerGUI() {

        // initialize JFrame object
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(masterPanel);
        frame.setVisible(true);

        // initializing the menu pannel
        menuPanel = new JPanel();
        menuPanel.setLayout(null);

        menuLabel = new JLabel("What do you want to do?");
        menuLabel.setBounds(10, 10, 200, 25);
        menuPanel.add(menuLabel);

        // setChangeFeeButton
        setChangeFeeButton = new JButton("Set or Change Fee");
        setChangeFeeButton.setBounds(10, 40, 200, 25);
        setChangeFeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(masterPanel, "2");
            }
        });
        menuPanel.add(setChangeFeeButton);

        // accessAllInfoButton
        accessAllInfoButton = new JButton("Access All Info");
        accessAllInfoButton.setBounds(10, 70, 200, 25);
        accessAllInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(masterPanel, "3");
            }
        });
        menuPanel.add(accessAllInfoButton);

        // genReportButton
        genReportButton = new JButton("Generate Periodical Report");
        genReportButton.setBounds(10, 100, 200, 25);
        genReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(masterPanel, "4");
            }
        });
        menuPanel.add(genReportButton);

        // changeStateButton
        changeStateButton = new JButton("Change State of Property");
        changeStateButton.setBounds(10, 130, 200, 25);
        changeStateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(masterPanel, "5");
            }
        });
        menuPanel.add(changeStateButton);

        // intializing setChangeFeePanel and adding necessary components
        setChangeFeePanel = new JPanel();
        setChangeFeePanel.setLayout(null);

        String currentFees = Driver.getPaymentFee();
        String currentDays = Driver.getNumberOfFeeDays();

        currentFeeDays = new JLabel("The current fee is " + currentFees + " for " + currentDays + " days.");
        currentFeeDays.setBounds(10, 10, 400, 25);
        setChangeFeePanel.add(currentFeeDays);

        setChangeFeeDirections = new JLabel("If you would like to change it, please enter the new values below.");
        setChangeFeeDirections.setBounds(10, 40, 400, 25);
        setChangeFeePanel.add(setChangeFeeDirections);

        feePriceLabel = new JLabel("Enter new fee price ($):");
        feePriceLabel.setBounds(10, 70, 190, 25);
        setChangeFeePanel.add(feePriceLabel);
        feePrice = new JTextField(25);
        feePrice.setBounds(200, 70, 50, 25);
        setChangeFeePanel.add(feePrice);

        feePeriodLabel = new JLabel("Enter new fee period (days):");
        feePeriodLabel.setBounds(10, 100, 190, 25);
        setChangeFeePanel.add(feePeriodLabel);
        feePeriod = new JTextField(25);
        feePeriod.setBounds(200, 100, 50, 25);
        setChangeFeePanel.add(feePeriod);

        submitFeeChanges = new JButton("Submit Fee Changes");
        submitFeeChanges.setBounds(10, 130, 170, 25);
        submitFeeChanges.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int per = -1;
                double pri = -1;

                boolean perCorrect = false;
                boolean priCorrect = false;

                try {
                    per = Integer.parseInt(feePeriod.getText());

                    if (per > 0) {
                        perCorrect = true;
                    } else {
                        perCorrect = false;
                    }
                } catch (Exception a) {
                    perCorrect = false;
                }

                try {
                    pri = Double.parseDouble(feePrice.getText());

                    if (pri > 0) {
                        priCorrect = true;
                    } else {
                        priCorrect = false;
                    }
                } catch (Exception a) {
                    priCorrect = false;
                }

                if (!perCorrect || !priCorrect) {
                    JOptionPane.showMessageDialog(null, "Input invalid, please try again");
                }
                else{
                    Driver.setFeeInfo(pri, per);
                    JOptionPane.showMessageDialog(null, "Changed the fees");
                }
            }
        });
        setChangeFeePanel.add(submitFeeChanges);
        
        JButton backButton1 = new JButton("Back to menu");
        backButton1.setBounds(30, 400, 150, 25);
        backButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(masterPanel, "1");
            }
        });
        setChangeFeePanel.add(backButton1);

        // intializing setAccessAllInfoPanel and adding necessary components
        accessAllInfoPanel = new JPanel();

        BoxLayout bl = new BoxLayout(accessAllInfoPanel, BoxLayout.Y_AXIS);
        accessAllInfoPanel.setLayout(bl);

        String[] renterAtts = {"Name", "Email", "ID"};
        String[] landlordAtts = {"Name", "Email", "ID"};
        String[] propertyAtts = {"Address", "Type", "Bed", "Bath", "Furnished", "Quadrant", "Owner ID", "Payment Expirey Date"};

        String[][] mockRenter = {   {"Harry", "harry@gmail.com", "123"}, 
                                    {"Athena", "athena@yahoo.com", "456"}};

        String[][] mockLandlord = { {"Arindam", "arindam@gmail.com", "789"},
                                    {"John", "john@hotmail.com", "420"}};

        String[][] mockProp = {     {"Bruhdale", "House", "2", "2", "true", "SW", "789", "2022-01-01"},
                                    {"Bro st", "Apartment", "1", "1", "false", "NW", "789", "2022-01-21"},
                                    {"mac hall", "Townhouse", "2", "1", "false", "NE", "420", "2022-03-01"}};


        JLabel ren = new JLabel("Renter data");
        accessAllInfoPanel.add(ren);
        JTable rentTable = new JTable(mockRenter, renterAtts);
        JScrollPane rscrol = new JScrollPane(rentTable);
        //rscrol.setBounds(30, 30, 440, 50);
        accessAllInfoPanel.add(rscrol);

        JLabel lan = new JLabel("Landlord data");
        accessAllInfoPanel.add(lan);
        JTable landTable = new JTable(mockLandlord, landlordAtts);
        JScrollPane lscrol = new JScrollPane(landTable);
        //lscrol.setBounds(30, 130, 440, 50);
        accessAllInfoPanel.add(lscrol);

        JLabel pro = new JLabel("Property data");
        accessAllInfoPanel.add(pro);
        JTable propTable = new JTable(mockProp, propertyAtts);
        JScrollPane pscrol = new JScrollPane(propTable);
        //pscrol.setBounds(30, 230, 440, 50);
        accessAllInfoPanel.add(pscrol);

        JButton backButton2 = new JButton("Back to menu");
        backButton2.setBounds(30, 400, 150, 25);
        backButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(masterPanel, "1");
            }
        });
        accessAllInfoPanel.add(backButton2);


        // intializing GenReportPanel and adding necessary components
        genReportPanel = new JPanel();
        BoxLayout bl2 = new BoxLayout(genReportPanel, BoxLayout.Y_AXIS);
        genReportPanel.setLayout(bl2);

        String xs = "Total number of houses listed in this period: ";
        int xi = Driver.totalHousesListedManager();
        xs += String.valueOf(xi);

        String ys = "Total number of houses rented in this period: ";
        int yi = Driver.totalRentedManager();
        ys += String.valueOf(yi);

        String zs = "Total number of active listing: ";
        int zi = Driver.totalActiveManager();
        zs += String.valueOf(zi);

        String as = "List of rented houses:";

        ArrayList<Property> rentedProps = Driver.listRented();

        System.out.println(rentedProps);

        Object [][] rentedHouse = new Object [rentedProps.size()][3];

        for(int i = 0; i < rentedProps.size(); i++){
            int j = 0;
            rentedHouse[i][j] = "Landlord Name";
            j++;
            rentedHouse[i][j] = rentedProps.get(i).getID();
            j++;          
            rentedHouse[i][j] = rentedProps.get(i).getAddress();
            j++;
        }


        String [] rentedHouseHeaders = {"Landlord Name", "Property ID", "Address"};
        // String [][] rentedHouseMock = { {"Gojo", "300", "Glizzy st"},
        //                                 {"Ron", "310", "tfdl"},
        //                                 {"Arule", "340", "Spooder"}};

        JLabel x = new JLabel(xs);
        x.setBounds(30, 30, 400, 25);
        genReportPanel.add(x);
        
        JLabel y = new JLabel(ys);
        y.setBounds(30, 60, 400, 25);
        genReportPanel.add(y);

        JLabel z = new JLabel(zs);
        z.setBounds(30, 90, 400, 25);
        genReportPanel.add(z);

        JLabel a = new JLabel(as);
        a.setBounds(30, 120, 400, 25);
        genReportPanel.add(a);

        JTable reportTable = new JTable(rentedHouse, rentedHouseHeaders);
        JScrollPane repscrol = new JScrollPane(reportTable);
        genReportPanel.add(repscrol);
        
        JButton backButton3 = new JButton("Back to menu");
        backButton3.setBounds(30, 400, 150, 25);
        backButton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(masterPanel, "1");
            }
        });
        genReportPanel.add(backButton3);

        // panel for changing listing state

        listingStatePanel = new JPanel();
        listingStatePanel.setLayout(null);

        JLabel listingTitleLabel = new JLabel("Change Listing State:");
        listingTitleLabel.setBounds(10, 20, 200, 25);
        listingStatePanel.add(listingTitleLabel);

        JLabel listingIDLabel = new JLabel("Property ID for State Change:");
        listingIDLabel.setBounds(10, 50, 200, 25);
        listingStatePanel.add(listingIDLabel);    
        
        JTextField listingIDText = new JTextField(20); 
        listingIDText.setBounds(300, 50, 200, 25);        
        listingStatePanel.add(listingIDText);          

        JLabel listingLabel = new JLabel("New Listing Status:");
        listingLabel.setBounds(10, 80, 200, 25);
        listingStatePanel.add(listingLabel);  

        String[] stateOptions = {"Active", "Rented", "Cancelled", "Suspended"};

        JComboBox listingcb = new JComboBox(stateOptions);
        listingcb.setBounds(300, 80, 200, 25);
        listingStatePanel.add(listingcb);

        JButton stateChangeButton = new JButton("Submit Change");
        stateChangeButton.setBounds(320, 110, 160, 25);         
        stateChangeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int listingID = Integer.parseInt(listingIDText.getText().toString());
                    if(listingID < 0){
                        JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again.");
                        return;
                    }
                    String newState = listingcb.getSelectedItem().toString();
                    Driver.changeListingState(listingID, newState);
                    JOptionPane.showMessageDialog(frame, "Listing state has been changed. Click okay to continue");
                    layout.show(masterPanel, "1");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(frame, "PropertyID was not valid. Please try again");
                }
            }
        });          
        listingStatePanel.add(stateChangeButton);          


        JButton backButton4 = new JButton("Back to menu");
        backButton4.setBounds(30, 400, 150, 25);
        backButton4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(masterPanel, "1");
            }
        });
        listingStatePanel.add(backButton4);

        layout = new CardLayout();
        masterPanel.setLayout(layout);
        masterPanel.add(menuPanel, "1");
        masterPanel.add(setChangeFeePanel, "2");
        masterPanel.add(accessAllInfoPanel, "3");
        masterPanel.add(genReportPanel, "4");
        masterPanel.add(listingStatePanel, "5");
        layout.show(masterPanel, "1");
    }
}
