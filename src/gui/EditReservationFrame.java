package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditReservationFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField confirmNumberField;
    private JLabel confirmLabel;
    private JButton checkButton;
    private JButton cancelButton;

    public EditReservationFrame() {

        frame.setTitle("Edit reservation");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panelComponents();
    }

    public void panelComponents() {

        confirmNumberField = new JTextField(5);
        confirmLabel = new JLabel("Please enter your confirmation number");
        checkButton = new JButton("Check in");
        cancelButton = new JButton("Cancel");

        checkButton.addActionListener(new buttonListener());
        cancelButton.addActionListener(new buttonListener());

        panel.add(confirmLabel);
        panel.add(confirmNumberField);
        panel.add(checkButton);
        panel.add(cancelButton);

        frame.add(panel);

    }

    class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == checkButton) {
                System.out.println("You are checked in!");
            }

            else {
                System.out.println("You are cancelling your edit");
            }
            
        }
        
    }
}