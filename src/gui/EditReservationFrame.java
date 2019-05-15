package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * This class opens a editFrame with a jtextfield where a guest 
 * can put their confirmation number to make edits to their existing reservations  
 */
public class EditReservationFrame {

    private JFrame editFrame = new JFrame();
    private JPanel editPanel = new JPanel();
    private JTextField confirmNumberField;
    private JLabel confirmLabel;
    private JButton checkButton;
    private JButton cancelButton;
    
    /**
     * The constructor that initializes the editFrame 
     */
    public EditReservationFrame() {

        editFrame.setTitle("Edit reservation");
        editFrame.setSize(800, 600);
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setVisible(true);
        panelComponents();
    }
    //Only use this method to add components to the editFrame
    /**
     * This method adds the jlabel, jtextfield, jbuttons to the editPanel and adds
     * it to the editFrame
     */
    public void panelComponents() {

        confirmNumberField = new JTextField(5);
        confirmLabel = new JLabel("Please enter your confirmation number");
        checkButton = new JButton("Find reservation");
        cancelButton = new JButton("Cancel");

        checkButton.addActionListener(new buttonListener());
        cancelButton.addActionListener(new buttonListener());

        editPanel.add(confirmLabel);
        editPanel.add(confirmNumberField);
        editPanel.add(checkButton);
        editPanel.add(cancelButton);

        editFrame.add(editPanel);

    }
    /**
     * This class is used to check if the buttons were clicked
     */
    class buttonListener implements ActionListener {
        /**
         * checks which button is pressed, if the checked in button is pressed 
         * it will go the newreservationframe, the cancel button will exit the editFrame
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == checkButton) {
               
                NewReservationFrame reservationFrame = new NewReservationFrame();
                reservationFrame.edit(); 
                editFrame.setVisible(false);
            }

            else {
                
                MainFrame mainFrame = new MainFrame(); 
                editFrame.setVisible(false);
            }
            
        }
        
    }
}