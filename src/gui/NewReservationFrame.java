package gui;

import javax.swing.*;

public class NewReservationFrame {
    //Frame info

    //Guest Info
    private JPanel panel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField phoneNumField;
    private JLabel phoneNumLabel;
    private JTextField addressField;
    private JLabel addressLabel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JLabel dateOfBirth;
    private JComboBox<Integer> year; 
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    

    //Credit Card Info
    private JLabel creditCardInfoLabel;
    private JLabel cardNumberLabel;
    private JLabel securityCodeLabel;
    private JLabel expirationDateLabel;

    //Room info
    private JComboBox roomTypeBox;
    private JComboBox roomNumberBox;
    private JLabel roomNumberLabel;
    private JLabel roomTypeLabel;
    
    private JFrame frame; 

    public NewReservationFrame() {
    	frame = new JFrame();
    	panel = new JPanel(); 
    	
        frame.setTitle("New Reservation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        guestInfo(); 
    }
    
    public void guestInfo() {
    	
    	nameField = new JTextField(5); 
    	nameLabel = new JLabel("Name");
        phoneNumField = new JTextField(5);
        phoneNumLabel = new JLabel("Phone number");
        addressField = new JTextField(5); 
        addressLabel = new JLabel("Address"); 
        emailField = new JTextField(10);
        emailLabel = new JLabel("Email address");
        dateOfBirth = new JLabel("Date of birth");
        year = new JComboBox<Integer>(); 
        month = new JComboBox<Integer>(); 
        day = new JComboBox<Integer>(); 

        for(int i = 0; i <= 12; i++) {
            year.addItem(i);
        }
        
        for (int i = 0; i <= 30; i++) {
            day.addItem(i);
        }

        for (int i = 1900; i <= 2019; i++ ) {
            day.addItem(i);
        }
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneNumLabel);
        panel.add(phoneNumField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(dateOfBirth);
        panel.add(month);
        panel.add(day);
        panel.add(year);
        
        frame.add(panel);

    	
    	
    }

}
