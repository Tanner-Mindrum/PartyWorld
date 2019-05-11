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
 * This class opens a frame with a jtextfield where a guest 
 * can put their confirmation number to make edits to their existing reservations  
 */
public class EditReservationFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField confirmNumberField;
    private JLabel confirmLabel;
    private JButton checkButton;
    private JButton cancelButton;
    /**
     * The constructor that initializes the frame 
     */
    public EditReservationFrame() {

        frame.setTitle("Edit reservation");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panelComponents();
    }
    //Only use this method to add components to the frame
    /**
     * This method adds the jlabel, jtextfield, jbuttons to the panel and adds
     * it to the frame
     */
    public void panelComponents() {

        confirmNumberField = new JTextField(5);
        confirmLabel = new JLabel("Please enter your confirmation number");
        checkButton = new JButton("Find reservation");
        cancelButton = new JButton("Cancel");

        checkButton.addActionListener(new buttonListener());
        cancelButton.addActionListener(new buttonListener());

        panel.add(confirmLabel);
        panel.add(confirmNumberField);
        panel.add(checkButton);
        panel.add(cancelButton);

        frame.add(panel);

    }
    /**
     * This class is used to check if the buttons were clicked
     */
    class buttonListener implements ActionListener {
        /**
         * checks which button is pressed, if the checked in button is pressed 
         * it will go the newreservationframe, the cancel button will exit the frame
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == checkButton) {
                System.out.println("This should open the new reservation frame with guest information that was filled out ");
            }

            else {
                System.out.println("You are cancelling your edit");
            }
            
        }
        
    }
}