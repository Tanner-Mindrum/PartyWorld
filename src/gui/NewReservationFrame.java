package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import AquaWorld.*;
import java.util.Calendar;
import java.util.Date;

public class NewReservationFrame {
    // Frame info

    // Guest Info
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

    // Credit Card Info
    private JLabel cardNameLabel; 
    private JLabel creditCardInfoLabel;
    private JLabel cardNumberLabel;
    private JLabel securityCodeLabel;
    private JLabel expirationDateLabel;
    
    private JTextField cardNumberField;
    private JTextField cardName;
    private JTextField securityCodeField;
    private JComboBox<Integer> expirationMonth;
    private JComboBox<Integer> expirationYear;

    // Room info
    private JComboBox<String> roomTypeBox;
    private JComboBox<Integer> roomNumberBox;
    private JLabel roomNumberLabel;
    private JLabel roomTypeLabel;
    
    
    private JButton reserveButton;
    private JButton cancelButton; 
    private JFrame frame;

    private final String[] roomTypes= {"Small Party Room", "Medium Party Room", "Karaoke Lounge", "Adult Billiards Lounge", "Aqua Room"};

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
        cardName = new JTextField(5);
        cardNameLabel = new JLabel("Name");
       
        roomTypeBox = new JComboBox<String>(roomTypes);
        roomNumberBox = new JComboBox<Integer>();
        roomTypeBox.addActionListener(new guestInfoListener());

        year = new JComboBox<Integer>();
        month = new JComboBox<Integer>();
        day = new JComboBox<Integer>();
       

        reserveButton = new JButton("Reserve");
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new guestInfoListener());
        reserveButton.addActionListener(new guestInfoListener());
        
        creditCardInfoLabel = new JLabel("Card information");
        cardNumberLabel = new JLabel("Credit card information");
        securityCodeLabel = new JLabel("Security code (3 digits)");
        expirationDateLabel = new JLabel("Expiration date");

        cardNumberField = new JTextField(15);
        securityCodeField = new JTextField(5);
        expirationMonth = new JComboBox<Integer>();
        expirationYear = new JComboBox<Integer>();

        // setting 12 months in the month dropdown menu
        for (int i = 1; i <= 12; i++) {
            month.addItem(i);
            expirationMonth.addItem(i);
        }
        // Settings the amount of days per month
        for (int i = 1; i <= 30; i++) {
            day.addItem(i);
        }
        // Settings years for date of birth
        for (int i = 1900; i <= 2019; i++) {
            year.addItem(i);

        }
        // Setting years for expiration date for credit card
        for (int i = 2019; i <= 2030; i++) {
            expirationYear.addItem(i);
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
        panel.add(creditCardInfoLabel);
        panel.add(cardNameLabel);
        panel.add(cardName);
        panel.add(cardNumberLabel);
        panel.add(cardNumberField);
        panel.add(securityCodeLabel);
        panel.add(securityCodeField);
        panel.add(expirationDateLabel);
        panel.add(expirationMonth);
        panel.add(expirationYear);
        panel.add(roomTypeBox);
        panel.add(roomNumberBox);
        panel.add(cancelButton);
        panel.add(reserveButton);
        frame.add(panel);

    }

    class guestInfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String roomType = (String) roomTypeBox.getSelectedItem();

            //Guest information to save 
            String tempName = nameField.getText();
            String tempPhoneNum = phoneNumField.getText();
            String tempAddress = addressField.getText();
            
            int tempDay = (Integer) day.getSelectedItem();
            int tempMonth = (Integer) month.getSelectedItem();
            int tempYear = (Integer) year.getSelectedItem();
            
            String tempCreditCardInfo = cardNumberField.getText();
            String tempEmail = emailField.getText();
            String tempCardName = cardName.getText();
            int tempExpirationMonth = (Integer) expirationMonth.getSelectedItem();
            int tempExpirationYear = (Integer) expirationYear.getSelectedItem();

            Calendar calendar = Calendar.getInstance(); 
        
            calendar.get(Calendar.YEAR);
            calendar.get(Calendar.MONTH);
            calendar.get(Calendar.DAY_OF_MONTH);
            
            
            PartyGoer guest = new PartyGoer();     
            
            if (e.getSource() == reserveButton) {
                guest.setName(tempName);
                guest.setPhoneNum(tempPhoneNum);
                guest.setAddress(tempAddress);
                guest.setDOB(tempMonth, tempDay, tempYear);
                guest.setCreditCardInfo(tempCreditCardInfo);
                guest.setRoomType(roomType);
                guest.setEmail(tempEmail);
                guest.setCardName(tempCardName);
                guest.setExpirationDate(tempExpirationMonth, tempExpirationYear);
                //Checking for their birthday is unfinished
                if (roomType.equals("Adult Billiards Lounge")) {
                    
                    if (calendar.get(Calendar.MONTH) - guest.getBirthYear() >= 20) {
                        
                        if (calendar.get(Calendar.MONTH) + 1 > guest.getBirthMonth()) {
                            System.out.println("You're good to go");
                        }

                        else if (calendar.get(Calendar.MONTH) + 1 == guest.getBirthMonth()) {
                            
                            if (calendar.get(Calendar.DAY_OF_MONTH) > guest.getBirthDay()) {

                                System.out.println("You're good to go");
                            }
                        }
                    }
                }
         
                //Not sure that we need the room type and room number for the partygoer object
                
           

            }
            
            else if (e.getSource() == cancelButton) {
                System.out.println("The cancel button was pressed");
            }

            else if (e.getSource() == roomTypeBox) {

                if (roomType.equals("Small Party Room") || roomType.equals("Karaoke Lounge")) {
                   
                    
                  
                    roomNumberBox.removeAllItems();
                   
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.repaint();
                    
                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    panel.add(roomNumberBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                                      
                }

                else if (roomType.equals("Medium Party Room")) {

                  
                    roomNumberBox.removeAllItems();
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.repaint();
                    
                    for (int i = 1; i <= 2; i++) {
                        roomNumberBox.addItem(i);
                    }

                    panel.add(roomNumberBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();

                }

                else if (roomType.equals("Adult Billiards Lounge")) {

                  
                    roomNumberBox.removeAllItems();
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.repaint();
                    
                    for (int i = 1; i <= 5; i++) {
                        roomNumberBox.addItem(i);
                    }

                    panel.add(roomNumberBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();

                }

                else {
                    
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.repaint();
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }

            }
        }
    }
}
