package gui;

import javax.swing.*;

public class NewReservationFrame extends JFrame {
    //Frame info

    //Guest Info
    private JPanel panel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField phoneNumField;
    private JLabel phoneNumLabel;
    private JTextField addressField;
    private JLabel addressLabel;
    private JSpinner dateOfBirthSpinner;
    private JTextField emailField;
    private JLabel emailLabel;

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

    private NewReservationFrame() {
        this.setTitle("New Reservation");
    }

}
