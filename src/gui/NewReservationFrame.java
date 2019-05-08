package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
    private JLabel creditCardInfoLabel;
    private JLabel cardNumberLabel;
    private JLabel securityCodeLabel;
    private JLabel expirationDateLabel;

    private JTextField cardNumberField;
    private JTextField securityCodeField;
    private JComboBox<Integer> expirationMonth;
    private JComboBox<Integer> expirationYear;

    // Room info
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

        creditCardInfoLabel = new JLabel("Card information");
        cardNumberLabel = new JLabel("Credit card information");
        securityCodeLabel = new JLabel("Security code (3 digits)");
        expirationDateLabel = new JLabel("Expiration date");

        cardNumberField = new JTextField(15);
        securityCodeField = new JTextField(5);
        expirationMonth = new JComboBox<Integer>();
        expirationYear = new JComboBox<Integer>();

        // setting 12 months in the month dropdown menu
        for (int i = 0; i <= 12; i++) {
            month.addItem(i);
            expirationMonth.addItem(i);
        }
        // Settings the amount of days per month
        for (int i = 0; i <= 30; i++) {
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
        panel.add(cardNumberLabel);
        panel.add(cardNumberField);
        panel.add(securityCodeLabel);
        panel.add(securityCodeField);
        panel.add(expirationDateLabel);
        panel.add(expirationMonth);
        panel.add(expirationYear);
        frame.add(panel);

    }

    class guestInfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            
        }
        
    }
}
