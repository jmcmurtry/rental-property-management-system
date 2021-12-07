package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.IntStream;

public class ManagerGUI {

    private JFrame frame;
    private JPanel panel;
    private JLabel reportLabel;

    private JLabel sdayLab;
    private JComboBox sdaycb;
    private JLabel smonthLab;
    private JComboBox smonthcb;
    private JLabel syearLab;
    private JComboBox syearcb;

    private JLabel edayLab;
    private JComboBox edaycb;
    private JLabel emonthLab;
    private JComboBox emonthcb;
    private JLabel eyearLab;
    private JComboBox eyearcb;

    private JButton genReportButton;

    private JButton addEditButton;

    private int[] d = IntStream.rangeClosed(1, 31).toArray();
    Integer[] days = IntStream.of(d).boxed().toArray(Integer[]::new);

    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    private int[] y = IntStream.rangeClosed(1980, 2021).toArray();
    Integer[] years = IntStream.of(y).boxed().toArray(Integer[]::new);

    public ManagerGUI() {
        frame = new JFrame("Manger Menu");
        panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        reportLabel = new JLabel("To generate report, enter time period...");
        reportLabel.setBounds(10, 20, 300, 25);
        panel.add(reportLabel);

        ///////////////////////////////////////////////////////////// start day
        sdayLab = new JLabel("Select start day");
        sdayLab.setBounds(10, 50, 200, 25);
        panel.add(sdayLab);

        sdaycb = new JComboBox(days);
        sdaycb.setBounds(10, 75, 75, 25);
        panel.add(sdaycb);

        ///////////////////////////////////////////////////////////// start month
        smonthLab = new JLabel("Select start month");
        smonthLab.setBounds(160, 50, 200, 25);
        panel.add(smonthLab);

        smonthcb = new JComboBox(months);
        smonthcb.setBounds(160, 75, 75, 25);
        panel.add(smonthcb);

        ///////////////////////////////////////////////////////////// start year
        syearLab = new JLabel("Select start year");
        syearLab.setBounds(310, 50, 200, 25);
        panel.add(syearLab);

        syearcb = new JComboBox(years);
        syearcb.setBounds(310, 75, 75, 25);
        panel.add(syearcb);



        ///////////////////////////////////////////////////////////// end day
        edayLab = new JLabel("Select end day");
        edayLab.setBounds(10, 100, 200, 25);
        panel.add(edayLab);

        edaycb = new JComboBox(days);
        edaycb.setBounds(10, 125, 75, 25);
        panel.add(edaycb);

        ///////////////////////////////////////////////////////////// end month
        emonthLab = new JLabel("Select end month");
        emonthLab.setBounds(160, 100, 200, 25);
        panel.add(emonthLab);

        emonthcb = new JComboBox(months);
        emonthcb.setBounds(160, 125, 75, 25);
        panel.add(emonthcb);

        ///////////////////////////////////////////////////////////// end year
        eyearLab = new JLabel("Select end year");
        eyearLab.setBounds(310, 100, 200, 25);
        panel.add(eyearLab);

        eyearcb = new JComboBox(years);
        eyearcb.setBounds(310, 125, 75, 25);
        panel.add(eyearcb);



        /////////////////////////////////////////////////////////////// generate report button
        genReportButton = new JButton("Generate report");
        genReportButton.setBounds(270, 20, 150, 25);

        genReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sday = sdaycb.getSelectedItem().toString();
                String smonth = smonthcb.getSelectedItem().toString();
                String syear = syearcb.getSelectedItem().toString();
                String eday = edaycb.getSelectedItem().toString();
                String emonth = emonthcb.getSelectedItem().toString();
                String eyear = eyearcb.getSelectedItem().toString();

                System.out.println("Start date: "+sday +" "+smonth+" "+syear);
                System.out.println("End date: "+eday+" "+emonth+" "+eyear);
            }
        });
        panel.add(genReportButton);



        ///////////////////////////////////////////////////////////////add/edit property button
        addEditButton = new JButton("Add/edit property listing fee");
        addEditButton.setBounds(10, 225, 300, 25);

        addEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("add/edit button clicked");
            }
        });
        panel.add(addEditButton);



        ///////////////////////////////////////////////////////////////access system user details button
        addEditButton = new JButton("Access system user user details");
        addEditButton.setBounds(10, 325, 300, 25);

        addEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("access system user details button clicked");
            }
        });
        panel.add(addEditButton);


        ///////////////////////////////////////////////////////////////change property status button
        addEditButton = new JButton("Change property status");
        addEditButton.setBounds(10, 425, 300, 25);

        addEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("change property status clicked");
            }
        });
        panel.add(addEditButton);


        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
